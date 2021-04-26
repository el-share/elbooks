package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Book;
import com.example.demo.model.Loan;

@Mapper
public interface DisplayMapper {
	List<Book>findBook();
	List<Loan>findByLoanUserId (int id);
}
