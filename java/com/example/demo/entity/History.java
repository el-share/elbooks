package com.example.demo.entity;

import lombok.Data;

@Data
public class History {
	private int book_id;
	private int user_id;
	private String loan_day;
	private String return_day;
}
