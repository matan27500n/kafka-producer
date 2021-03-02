package com.matan.kafka.springkafkaproducer.service;

import org.springframework.stereotype.Service;
import com.matan.kafka.springkafkaproducer.repo.EventRepository;

@Service
public class EventService {

	private EventRepository eventRepository;

	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}

	public Integer getAllEventsSize() {
		return eventRepository.findAll().size();
	}
}
