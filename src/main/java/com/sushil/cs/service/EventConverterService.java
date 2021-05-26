package com.sushil.cs.service;

import com.sushil.cs.Application;
import com.sushil.cs.model.EventDetail;
import com.sushil.cs.entity.EventEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * The type Event converter service.
 */
@Service
public class EventConverterService {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    /**
     * Convert event to entity event entity.
     *
     * @param startEvent  the start event
     * @param finishEvent the finish event
     * @return the event entity
     */
    public EventEntity convertEventToEntity(EventDetail startEvent, EventDetail finishEvent){
        Long duration =  finishEvent.getTimestamp() - startEvent.getTimestamp();
        boolean isAlert = duration > 4;
        if (isAlert)
            log.info("Alert for ID : "+startEvent.getId() +" , Event is taking more than 4 ms for completion");
        return new EventEntity(startEvent.getId(), duration, startEvent.getType(), startEvent.getHost(), isAlert);
    }
}
