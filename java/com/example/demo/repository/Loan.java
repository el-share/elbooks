package com.example.demo.repository;

import lombok.Data;

@Data
public class Loan {
	private int book_id;
	private int user_id;
	private String loan_day;
	private String plan_day;
}
