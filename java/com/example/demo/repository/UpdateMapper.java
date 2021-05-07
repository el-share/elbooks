package com.example.demo.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Book;
import com.example.demo.model.User;

@Mapper
public interface UpdateMapper {
	void updateUser(User user);
	void deleteUser(int id);
	void updateBook(Book book);
	Optional<Book>findByHistoryBook(int id);
}
