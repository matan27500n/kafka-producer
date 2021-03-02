package com.matan.kafka.springkafkaproducer.utils;

import java.util.Date;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.matan.kafka.springkafkaproducer.model.Event;
import com.matan.kafka.springkafkaproducer.service.EventService;

@Component
public class EventProducer {

	private KafkaTemplate<String, Event> kafkaTemplate;
	private int count;

	public EventProducer(KafkaTemplate<String, Event> kafkaTemplate, EventService eventService) {
		this.kafkaTemplate = kafkaTemplate;
		this.count = eventService.getAllEventsSize();
	}

	private static final String TOPIC = "events";

	@Scheduled(fixedRate = 15000)
	public void createEvent() {
		count++;
		kafkaTemplate.send(TOPIC, new Event(count, new Date(), count + 1, count + 2, "created event: " + count));
	}
}
