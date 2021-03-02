package com.matan.kafka.springkafkaproducer.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.matan.kafka.springkafkaproducer.model.Event;

@Repository
public interface EventRepository extends MongoRepository<Event, Integer> {

}
