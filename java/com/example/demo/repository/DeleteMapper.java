package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Loan;

@Mapper
public interface DeleteMapper {
	void deleteLoan(Loan loan);
}
