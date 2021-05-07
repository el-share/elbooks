package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Book;
import com.example.demo.model.Loan;
import com.example.demo.repository.DeleteMapper;
import com.example.demo.repository.DisplayMapper;
import com.example.demo.repository.InsertMapper;
import com.example.demo.repository.UpdateMapper;

@Controller
@RequestMapping("/")
public class TESTBookController {

	@Autowired
	DisplayMapper displayMapper;

	@Autowired
	InsertMapper insertMapper;

	@Autowired
	UpdateMapper updateMapper;

	@Autowired
	DeleteMapper deleteMapper;

	@GetMapping("book")
    public String bodal(Model model) {
		model.addAttribute("bookList",displayMapper.findBook());
    	return "pages/book";
    }

	@GetMapping("rental")
    public String bookHistory(@ModelAttribute Loan loan, Model model) {
		model.addAttribute("rentalList",displayMapper.findByLoanUserId(1));
    	return "pages/book_history";
    }

	@PostMapping("return")
    public String bookReturn(@RequestParam int b_id) {
		insertMapper.insertHistory(b_id);

		Optional<Book>bookOptional = updateMapper.findByHistoryBook(b_id);
		Book book = bookOptional.get();
		int max_num = book.getMax_num() +1;
		book.setMax_num(max_num);
		book.setBook_id(b_id);
		updateMapper.updateBook(book);

		Loan loan = new Loan();
		loan.setBook_id(b_id);
		loan.setUser_id(1);
		deleteMapper.deleteLoan(loan);
		System.out.println(loan);
		// loan = null;
    	return "redirect:/rental";
    }

}