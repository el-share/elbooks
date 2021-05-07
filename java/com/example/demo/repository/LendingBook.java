package com.example.demo.repository;

import javax.validation.constraints.NegativeOrZero;

import lombok.Data;

@Data
public class LendingBook {

	@NegativeOrZero(message="すでに登録されています")
	private int book_id;

	private int user_id;
	private String loan_day;
	private String plan_day;

	private int max_num;
	private String category;
	private String title;
	private String author;

}
