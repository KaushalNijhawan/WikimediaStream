package com.spring.wikimedia.producerProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.wikimedia.producerProject.producerService.WikimediaProducer;

@SpringBootApplication
public class WikiMediaProducerConfiguration implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(WikiMediaProducerConfiguration.class, args);
	}

	@Autowired
	private WikimediaProducer wikimediaProducer;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		wikimediaProducer.sendMessage();
		
	}
}
