package com.matan.kafka.springkafkaproducer.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.matan.kafka.springkafkaproducer.model.Event;

@Service
public class ProducerService {

	@Autowired
	private KafkaTemplate<String, Event> kafkaTemplate;

	private static final String TOPIC = "Kafka_Example";

	int count = 1;

	@Scheduled(fixedRate = 1000)
	public void createEvent() {
		kafkaTemplate.send(TOPIC,
				new Event(count, new Date(), count + 1, count + 2, "full date: " + new Date().toString()));
		count++;
	}
}