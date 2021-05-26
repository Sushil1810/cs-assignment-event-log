package com.sushil.cs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sushil.cs.model.EventDetail;
import com.sushil.cs.entity.EventEntity;
import com.sushil.cs.repo.EventRepository;
import com.sushil.cs.service.EventConverterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import static com.sushil.cs.model.EventDetail.State.STARTED;

/**
 * The type Application.
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application implements ApplicationRunner{

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    private final ObjectMapper objectMapper;
    private final EventConverterService eventConverterService;
    private final EventRepository eventRepository;

    private Map<String, EventDetail> startedMap = new ConcurrentHashMap<>();
    private Map<String, EventDetail> finishedMap = new ConcurrentHashMap<>();

    /**
     * Instantiates a new Application.
     *
     * @param objectMapper          the object mapper
     * @param eventConverterService the event converter service
     * @param eventRepository       the event repository
     */
    @Autowired
    public Application(ObjectMapper objectMapper, EventConverterService eventConverterService, EventRepository eventRepository) {
        this.objectMapper = objectMapper;
        this.eventConverterService = eventConverterService;
        this.eventRepository = eventRepository;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        log.info("Starting Application");
        SpringApplication.run(Application.class, args);
        log.info("Application Started Successfully");
    }

    @Override
    public void run(ApplicationArguments applicationArgs) throws Exception {
        String args[] = applicationArgs.getSourceArgs();

        if (args.length != 1 || args[0].isEmpty()) {
            throw new Exception("Please provide a single log file filePath argument");
        }
        String filePath = args[0];
        log.info("Given file path : " +filePath);

        log.info("Started processing on file {}", filePath);
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            bufferedReader.lines().forEach(this::differentiateByEventState);

            log.info("Processing provided log data");

            processLogData(startedMap.keySet());

            log.info("Finished Processing data");

        } catch (IOException e) {
            log.error("Exception occurred while reading file...", e);
            throw e;
        }

    }

    private void differentiateByEventState(String eventJson) {
        try {
            log.info("Convert JSON to EventDetails Object");
            EventDetail eventDetail = Optional.ofNullable(objectMapper.readValue(eventJson , EventDetail.class))
                    .orElseThrow(() -> new Exception("Error Occurred while converting to json"));

            if (eventDetail.getState().equals(STARTED)) {
                log.info("Start Event for Id : "+eventDetail.getId());
                startedMap.put(eventDetail.getId(), eventDetail);
            } else {
                log.info("Finish Event for Id : "+eventDetail.getId());
                finishedMap.put(eventDetail.getId(), eventDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void processLogData(Set<String> eventIds){
        for (String eventId : eventIds){
            EventDetail startEventDetail = startedMap.get(eventId);
            EventDetail finishEventDetail = finishedMap.get(eventId);
            if (Optional.ofNullable(startEventDetail).isPresent() && Optional.ofNullable(finishEventDetail).isPresent()){
                log.info("Converting EventDetails Obj to Event Entity Object for ID - "+startEventDetail.getId());
                EventEntity eventEntity = eventConverterService.convertEventToEntity(startEventDetail ,finishEventDetail);
                log.info("converted event to entity for Event ID - "+startEventDetail.getId());

                log.info("Saving Entity to HSql DB for Event ID : "+startEventDetail.getId());
                eventRepository.save(eventEntity);
                log.info("Saved Entity to HSql DB for Event ID :"+startEventDetail.getId());

            }

        }


    }

}
