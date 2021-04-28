package com.example.demo.controller;

import java.awt.print.Book;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Mapper.BookMapper;
import com.example.demo.repository.History;
//import com.example.demo.repository.Book;
import com.example.demo.repository.LendingBook;
import com.example.demo.service.LendingService;

@Controller
@RequestMapping("/elbooks")
public class LendingController {

	@Autowired
	BookMapper bookMapper;
	@Autowired
	LendingService lendingService;

	// 貸出画面
	@GetMapping("/booklist")
	public String booklist(Model model) {
		List<Book> list = bookMapper.select();
		model.addAttribute("Book", list);
		return "booklist";
	}

	@PostMapping("/book")
	public String insertBook(@ModelAttribute LendingBook lendingBook) {
		int user_id;
//		List<Book> book = bookMapper.bookSelect(1);
//		Book book = bookOptional.get();
		user_id = 1;
		lendingBook.setBook_id(4);
		lendingBook.setUser_id(user_id);
		lendingBook.setPlan_day("2021-05-01");
		lendingService.insertBook(lendingBook);
//		bookMapper.update(book);
		return "redirect:/elbooks/booklist";
	}

	// 返却
	@GetMapping("/returnlist")
	public String returnlist(Model model) {
		List<LendingBook> list = bookMapper.returnSelect();
		model.addAttribute("LendingBook", list);
		return "returnlist";
	}

	@PostMapping("/returnBook")
	public String insertReturnBook(@ModelAttribute History history) {
//		LendingBook lendingBook = new LendingBook();
//		lendingBook.setBook_id(1);
//		lendingBook.setUser_id(1);
		lendingService.insertReturnBook(history);
		bookMapper.returnDelete();
		return "redirect:/elbooks/booklist";
	}


	@GetMapping("/book")
	public String Book() {

		return "book";
	}

	@GetMapping("/bookAdd")
	public String bookAdd() {

		return "bookAdd";
	}
}
