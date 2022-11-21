package com.spring.idgeneration.entity;



import java.io.Serializable;
import java.util.regex.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class Book implements Serializable{

	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	
	@Id
	private int no;
	private String bookname;
	private String author;
	


	public void setno(int no) {
		this.no = no;
	}

	public String getName() {
		return bookname;
	}

	public void setName(String name) {
		this.bookname = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getno() {
		return no;
	}
	

	
}
