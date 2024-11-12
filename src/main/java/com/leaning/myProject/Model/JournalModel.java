package com.leaning.myProject.Model;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;


public class JournalModel {

	private ObjectId id;
	
	private String title;
	
	private String content;

	
	public ObjectId getId() {
		return id;
	}


	public void setId(ObjectId id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public JournalModel() {
	}
	
	
}
