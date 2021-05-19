//
package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.common.Book;
import com.example.demo.entity.common.History;
import com.example.demo.entity.display.lendingbook.LendingBook;
import com.example.demo.entity.display.login.LoginUserDetailsImpl;
import com.example.demo.mapper.book_a.BookMapper_a;
import com.example.demo.service.LendingService;

@Controller
@RequestMapping("/elbooks")
public class LendingController {

	@Autowired
	BookMapper_a bookMapper;
	@Autowired
	LendingService lendingService;

	// 貸出画面
	@GetMapping("/booklist")
	public String booklist(Model model) {
		List<Book> list = bookMapper.select();
		model.addAttribute("Book", list);
		model.addAttribute("lendingBook", new LendingBook());
		return "/pages/booklist";
	}

	/**
	 * 借りる機能
	 * 編集日：2021/5/18
	 * 編集：オオヒラ
	 * コメント：マージしました。
	 */
	@PostMapping("/book")
	public String insertBook(@AuthenticationPrincipal LoginUserDetailsImpl user,@ModelAttribute LendingBook lendingBook,@ModelAttribute Book book, @RequestParam int rental_maxnum, @RequestParam int rentalBookId) {
		//user_idをログインユーザーから取得してセット
		lendingBook.setUser_id(user.getLoginUser().getUser_id());
		int max_num = rental_maxnum -1;
		book.setMax_num(max_num);
		book.setBook_id(lendingBook.getBook_id());
		//サービス呼び出し
		lendingService.updateMax_num(book);
		lendingService.insertBook(lendingBook);
		
		//		bookMapper.update(book);
		return "redirect:/mypage";
	}

	// 返却
	@GetMapping("/returnlist")
	public String returnlist(Model model, @ModelAttribute History history) {
		List<LendingBook> list = bookMapper.returnSelect();
		model.addAttribute("LendingBook", list);
		return "/pages/returnlist";
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
