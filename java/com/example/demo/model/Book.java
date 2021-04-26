package com.example.demo.model;

import lombok.Data;

@Data
public class Book {
	private int book_id;
	private String title;
	private String author;
	private int category_id;
	private int max_num;
	private String entry_day;
	private String updatetime;
	private int isdeleted;
	private int page;
}
