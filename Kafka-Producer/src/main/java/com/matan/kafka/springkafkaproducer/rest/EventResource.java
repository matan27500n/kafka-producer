package com.matan.kafka.springkafkaproducer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.matan.kafka.springkafkaproducer.service.ProducerService;

@RestController
@RequestMapping("/kafka")
public class EventResource {

	@Autowired
	private ProducerService producerService;

	@PostMapping("/createEvent")
	public String createEvent() {
		producerService.createEvent();
		return "Published successfully!";
	}
}
