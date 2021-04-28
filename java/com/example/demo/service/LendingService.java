package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.BookMapper;
import com.example.demo.repository.History;
import com.example.demo.repository.LendingBook;

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
