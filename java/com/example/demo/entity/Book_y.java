package com.example.demo.entity;

import lombok.Data;

@Data
public class Book_y {
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
