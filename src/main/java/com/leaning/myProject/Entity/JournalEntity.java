package com.leaning.myProject.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection="journals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JournalEntity {

	@Id
	private ObjectId id;
	private String title;
	private String content;
	
}
