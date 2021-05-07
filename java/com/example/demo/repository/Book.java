package com.example.demo.repository;

import lombok.Data;

@Data
public class Book {
	private int book_id;
	private int user_id;
	private String title;
	private String author;
	private int category_id;
	private int max_num;
	private String entry_day;
	private String updatetime;
	private int isdeleted;
	private int page;
	private String plan_day;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

}
