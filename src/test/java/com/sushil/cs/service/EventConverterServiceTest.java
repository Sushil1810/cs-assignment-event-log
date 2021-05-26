package com.sushil.cs.service;

import com.sushil.cs.entity.EventEntity;
import com.sushil.cs.model.EventDetail;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventConverterServiceTest {

    EventConverterService eventConverterService = new EventConverterService();

    @Test
    void convertEventToEntity_Success_Alert_False_Test() {
        EventDetail startEvent = new EventDetail("testId", EventDetail.State.STARTED,"APP_LOG","HOST",12345L);
        EventDetail finishEvent = new EventDetail("testId", EventDetail.State.FINISHED,"APP_LOG","HOST",12344L);
        EventEntity eventEntity = eventConverterService.convertEventToEntity(startEvent, finishEvent);
        assertFalse(eventEntity.isAlert());
    }

    @Test
    void convertEventToEntity_Success_Alert_True_Test() {
        EventDetail startEvent = new EventDetail("testId", EventDetail.State.STARTED,"APP_LOG","HOST",12345L);
        EventDetail finishEvent = new EventDetail("testId", EventDetail.State.FINISHED,"APP_LOG","HOST",12359L);
        EventEntity eventEntity = eventConverterService.convertEventToEntity(startEvent, finishEvent);
        assertTrue(eventEntity.isAlert());
    }
}