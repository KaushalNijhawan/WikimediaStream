package com.spring.wikimedia.producerProject.producerService;

import org.springframework.kafka.core.KafkaTemplate;

import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EventHandellerWikimedia implements BackgroundEventHandler{

	KafkaTemplate<String, String> kafkaTemplate;
	String topic;
	
	public EventHandellerWikimedia(KafkaTemplate<String, String> kafkaTemplate , String topic) {
		this.kafkaTemplate = kafkaTemplate;
		this.topic  = topic;
	}
	
	@Override
	public void onOpen() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClosed() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		
		log.info("Message update in WikiMedia "  + messageEvent.getData()) ;
		log.info("Receieved Dara for topic " + topic);
		kafkaTemplate.send(topic, messageEvent.getData());	
	}

	@Override
	public void onComment(String comment) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Throwable t) {
		// TODO Auto-generated method stub
		
	}

}
