package com.example.demo.entity;

import org.springframework.lang.NonNull;

import lombok.Data;


@Data
public class LoginUser{
    
    @NonNull
	private int user_id;

	@NonNull
	private String user_name;

	@NonNull
	private String pass;


}