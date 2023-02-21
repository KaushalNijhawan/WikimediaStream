package com.spring.wikimedia.consumerProject.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Document(collection = "WikimediaData")
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Wikimedia {

	@MongoId
	private String id;
	private String wikimediaData;
	
}
