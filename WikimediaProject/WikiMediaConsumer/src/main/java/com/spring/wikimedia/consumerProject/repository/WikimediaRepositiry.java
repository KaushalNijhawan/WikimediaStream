package com.spring.wikimedia.consumerProject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.wikimedia.consumerProject.model.Wikimedia;

@Repository
public interface WikimediaRepositiry extends MongoRepository<Wikimedia, String>{

}
