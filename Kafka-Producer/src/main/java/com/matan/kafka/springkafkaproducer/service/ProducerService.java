package com.matan.kafka.springkafkaproducer.service;

import java.util.Date;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.matan.kafka.springkafkaproducer.model.Event;

@Service
public class ProducerService {

	private KafkaTemplate<String, Event> kafkaTemplate;

	public ProducerService(KafkaTemplate<String, Event> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	private static final String TOPIC = "eventsProducer";
	private int count = 1;

	@Scheduled(fixedRate = 10000)
	public void createEvent() {
		kafkaTemplate.send(TOPIC, new Event(count, new Date(), count + 1, count + 2, "created event: " + count));
		count++;
	}
}
