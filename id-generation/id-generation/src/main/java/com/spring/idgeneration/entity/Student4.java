   package com.spring.idgeneration.entity;

import org.springframework.data.annotation.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "students")
public class Student4 {
	 @Transient
	    public static final String SEQUENCE_NAME = "users_sequence";
	 @Id
	private int id;
	private String name;
	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student4 [id=" + id + ", name=" + name + "]";
	}


	}
	

