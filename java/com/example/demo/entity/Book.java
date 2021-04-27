package com.example.demo.entity;

import lombok.Data;

@Data
public class Book {

	private Long bookId;
	private String title;
	private String author;

	//
	private int maxNum;
	private int page;
	private Long id;
}