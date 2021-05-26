package com.sushil.cs.service;

import com.sushil.cs.model.EventDetail;
import com.sushil.cs.entity.EventEntity;
import org.springframework.stereotype.Service;

@Service
public class EventConverterService {

    public EventEntity convertEventToEntity(EventDetail startEvent, EventDetail finishEvent){
        Long duration =  finishEvent.getTimestamp() - startEvent.getTimestamp();
        boolean isAlert = duration > 4;
        return new EventEntity(startEvent.getId(), duration, startEvent.getType(), startEvent.getHost(), isAlert);
    }
}
