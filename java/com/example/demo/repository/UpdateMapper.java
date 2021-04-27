package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UpdateMapper {
	void updateUser(User user);
	void deleteUser(int id);
}
