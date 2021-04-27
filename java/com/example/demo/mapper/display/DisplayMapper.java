package com.example.demo.mapper.display;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Book_y;
import com.example.demo.entity.Loan;
import com.example.demo.entity.User;



@Mapper
public interface DisplayMapper {
	List<Book_y>findBook();
	List<User>findUser();
	List<Loan>findByLoanUserId (int id);

}
