package com.matan.kafka.springkafkaproducer.rest;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.matan.kafka.springkafkaproducer.model.Event;

@RestController
@RequestMapping("/kafka")
public class EventResource {

	@Autowired
	KafkaTemplate<String, Event> kafkaTemplate;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplateDate;

	private static final String TOPIC = "Kafka_Example";

	@GetMapping("/create")
	public String post() {
		Runnable createEvents = new Runnable() {
			public void run() {
				kafkaTemplate.send(TOPIC, new Event(1, 1, 1, "event 1 created"));
				kafkaTemplateDate.send(TOPIC, new Date().toString());
			}
		};
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		executor.scheduleAtFixedRate(createEvents, 0, 3, TimeUnit.SECONDS);
		return "Published successfully!";
	}
}
