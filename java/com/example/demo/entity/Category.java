package com.example.demo.entity;

import lombok.Data;

@Data
public class Category {
	private int category_id;
	private String category;
	private String entry_day;
	private String updatetime;
	private int isdeleted;
}
