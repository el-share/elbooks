package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.DisplayMapper;

@Controller
@RequestMapping("/")
public class BookController {

	@Autowired
	DisplayMapper displayMapper;

	@GetMapping("/book")
    public String Modal(Model model) {
		model.addAttribute("bookList",displayMapper.findBook());
    	return "pages/book";
    }

	@GetMapping("rental")
    public String BookHistory(Model model) {
		model.addAttribute("rentalList",displayMapper.findByLoanUserId(1));
    	return "pages/book_history";
    }

}