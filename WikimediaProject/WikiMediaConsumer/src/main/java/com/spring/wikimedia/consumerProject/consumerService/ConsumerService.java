package com.spring.wikimedia.consumerProject.consumerService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.spring.wikimedia.consumerProject.model.Wikimedia;
import com.spring.wikimedia.consumerProject.repository.WikimediaRepositiry;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ConsumerService {

	private WikimediaRepositiry wikimediaRepo;
	
	public ConsumerService(WikimediaRepositiry wikimediaRepo) {
		this.wikimediaRepo = wikimediaRepo;
	}
	
	@KafkaListener(groupId = "myGroup", topics="Wikimedia")
	public void receiveMessage(String message) {
		log.info("Received message from producer is " + message);
		
		Wikimedia wiki = new Wikimedia();
		wiki.setWikimediaData(message);
		wikimediaRepo.save(wiki);
	}
}
