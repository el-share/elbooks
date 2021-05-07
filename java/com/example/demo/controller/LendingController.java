package com.example.demo.controller;

//import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Mapper.BookMapper;
import com.example.demo.repository.Book;
import com.example.demo.repository.History;
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
		model.addAttribute("lendingBook", new LendingBook());
		return "booklist";
	}

	@PostMapping("/book")
	public String insertBook(@ModelAttribute LendingBook lendingBook, @ModelAttribute Book book, @RequestParam int rental_maxnum, @RequestParam int rentalBookId) {
		int user_id;
		int max_num = rental_maxnum -1;
		user_id = 1;
		lendingBook.setBook_id(rentalBookId);
		lendingBook.setUser_id(user_id);
		book.setMax_num(max_num);
		book.setBook_id(rentalBookId);
		lendingBook.setPlan_day("2021-05-01");
		lendingService.updateMax_num(book);
		lendingService.insertBook(lendingBook);
		return "redirect:/elbooks/booklist";
	}

	// 返却
	@GetMapping("/returnlist")
	public String returnlist(Model model, @ModelAttribute History history) {
		List<LendingBook> list = bookMapper.returnSelect();
		model.addAttribute("LendingBook", list);
		return "returnlist";
	}

	@PostMapping("/returnbook")
	public String returnInsert(@RequestParam int returnBookId) {
		Optional<Book> optional = bookMapper.maxnumSelect(returnBookId);
		Book book = optional.get();
		int max_num = book.getMax_num() +1;
		book.setMax_num(max_num);
		book.setBook_id(returnBookId);
		lendingService.updateMax_num(book);
		System.out.println(book);
		lendingService.insertReturnBook(returnBookId);
		lendingService.returndelete(returnBookId);
		return "redirect:/elbooks/returnlist";
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
