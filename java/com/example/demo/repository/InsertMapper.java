package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface InsertMapper {
	void insertUser(User user);
}
