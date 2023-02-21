package com.spring.wikimedia.producerProject.producerService;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.background.BackgroundEventHandler;
import com.launchdarkly.eventsource.background.BackgroundEventSource;
import com.launchdarkly.eventsource.background.BackgroundEventSource.Builder;
import com.spring.wikimedia.producerProject.constants.ProducerConstants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class WikimediaProducer {
	
	private KafkaTemplate<String, String> kafkaTemplate;
	public WikimediaProducer(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	public void sendMessage() throws InterruptedException{
		String topic = ProducerConstants.TOPIC_WIKIMEDIA;
		
		BackgroundEventHandler eventHandler = new EventHandellerWikimedia(kafkaTemplate, topic);
		
		String url = "https://stream.wikimedia.org/v2/stream/recentchange";
		
		BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(eventHandler,new EventSource.Builder(URI.create(url)));
	
		BackgroundEventSource eventSource = builder.build();
		
		eventSource.start();
		
		TimeUnit.MINUTES.sleep(10);
	}
}
