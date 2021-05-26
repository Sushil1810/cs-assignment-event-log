package com.sushil.cs;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sushil.cs.model.EventDetail;
import com.sushil.cs.repo.EventRepository;
import com.sushil.cs.service.EventConverterService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.ApplicationArguments;

@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

    @Mock
    private ApplicationArguments applicationArgs;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private EventConverterService eventConverterService;

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private Application application;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        application = new Application(objectMapper, eventConverterService, eventRepository);
    }

    @Test
    public void application_Success_Start_Event_Test() throws Exception {
        String args[] = {"src/main/resources/sampleLogEvent.txt"};
        Mockito.when(applicationArgs.getSourceArgs()).thenReturn(args);
        EventDetail eventDetail = new EventDetail("scsmbstgra", EventDetail.State.STARTED,"APPLICATION_LOG","12345", 123467L);
        Mockito.when(objectMapper.readValue(Mockito.anyString(),Mockito.eq(EventDetail.class))).thenReturn(eventDetail);
        application.run(applicationArgs);
    }

    @Test
    public void application_Success_Finish_Event_Test() throws Exception {
        String args[] = {"src/main/resources/sampleLogEvent.txt"};
        Mockito.when(applicationArgs.getSourceArgs()).thenReturn(args);
        EventDetail eventDetail = new EventDetail("scsmbstgra", EventDetail.State.FINISHED,"APPLICATION_LOG","12345", 123467L);
        Mockito.when(objectMapper.readValue(Mockito.anyString(),Mockito.eq(EventDetail.class))).thenReturn(eventDetail);
        application.run(applicationArgs);
    }

    @Test(expected = Exception.class)
    public void application_No_CommandLineArgument_Exception_Test() throws Exception {
        String args[] = {};
        Mockito.when(applicationArgs.getSourceArgs()).thenReturn(args);
        application.run(applicationArgs);
    }

    @Test(expected = Exception.class)
    public void application_Invalid_File_Name_Exception_Test() throws Exception {
        String args[] = {"src/main/resources/invalidName.txt"};
        Mockito.when(applicationArgs.getSourceArgs()).thenReturn(args);
        application.run(applicationArgs);
    }
}