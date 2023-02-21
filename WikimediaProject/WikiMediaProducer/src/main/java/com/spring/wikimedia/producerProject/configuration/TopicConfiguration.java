package com.spring.wikimedia.producerProject.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.spring.wikimedia.producerProject.constants.ProducerConstants;
import com.spring.wikimedia.producerProject.producerService.WikimediaProducer;

@Configuration
public class TopicConfiguration {

	@Bean
	public NewTopic creatTopic() {
		return TopicBuilder.name(ProducerConstants.TOPIC_WIKIMEDIA).build();
	}
	
}
