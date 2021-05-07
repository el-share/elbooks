package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Book;
import com.example.demo.model.Loan;
import com.example.demo.model.User;

@Mapper
public interface DisplayMapper {
	List<Book>findBook();
	List<User>findUser();
	List<Loan>findByLoanUserId (int id);
}
