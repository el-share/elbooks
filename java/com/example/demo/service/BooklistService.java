package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Book_t;
import com.example.demo.mapper.booklist.BooklistMapper;



@Service
public class BooklistService {

	@Autowired
	BooklistMapper booklistMapper;

//	本一覧表示
	public List<Book_t> findAll() {

		return booklistMapper.findAll();
	}

//	書籍名で検索
	public List<Book_t> findtitle(String title) {

		return booklistMapper.findtitle(title);
	}

//	著者名で検索
	public List<Book_t> findauthor(String title) {

		return booklistMapper.findauthor(title);
	}

}
