package com.matan.kafka.springkafkaproducer.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.matan.kafka.springkafkaproducer.model.Event;

public interface EventRepository extends MongoRepository<Event, Integer> {

}
