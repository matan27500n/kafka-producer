package com.matan.kafka.springkafkaproducer.service;

import java.util.Date;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.matan.kafka.springkafConsumer.service.EventService;
import com.matan.kafka.springkafkaproducer.model.Event;

@Service
public class ProducerService {

	private KafkaTemplate<String, Event> kafkaTemplate;
	private int count;

	public ProducerService(KafkaTemplate<String, Event> kafkaTemplate, EventService eventService) {
		this.kafkaTemplate = kafkaTemplate;
		this.count = eventService.getAllEvents().size();
	}

	private static final String TOPIC = "events";

	@Scheduled(fixedRate = 15000)
	public void createEvent() {
		count++;
		kafkaTemplate.send(TOPIC, new Event(count, new Date(), count + 1, count + 2, "created event: " + count));
	}
}
