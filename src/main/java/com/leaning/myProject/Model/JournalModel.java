package com.leaning.myProject.Model;

import org.springframework.stereotype.Component;


public class JournalModel {

	long id;
	
	String title;
	
	String content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public JournalModel(long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	
	
}
