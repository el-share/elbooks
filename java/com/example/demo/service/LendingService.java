package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Mapper.BookMapper;
import com.example.demo.repository.Book;
import com.example.demo.repository.LendingBook;

@Service
public class LendingService {

	@Autowired
	BookMapper bookMapper;

	// 貸出
	public void insertBook(LendingBook lendingBook) {
		bookMapper.insert(lendingBook);
	}

	public void updateMax_num(Book book) {
		bookMapper.update(book);
	}

	// 返却
	public void insertReturnBook(int id) {
		bookMapper.returnInsert(id);
	}

	public void returndelete(int book_id) {
		bookMapper.returnDelete(book_id);
	}

}
