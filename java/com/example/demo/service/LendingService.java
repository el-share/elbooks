package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.History;
import com.example.demo.entity.LendingBook;
import com.example.demo.mapper.book.BookMapper;



@Service
public class LendingService {

	@Autowired
	BookMapper bookMapper;

	// 貸出
	public void insertBook(LendingBook lendingBook) {
		bookMapper.insert(lendingBook);
	}

	// 返却
	public void insertReturnBook(History history) {
		bookMapper.returnInsert(history);
	}



}
