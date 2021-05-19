//
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "/pages/booklist";
	}

	/**
	 * 借りる機能
	 * 編集日：2021/5/18
	 * 編集：オオヒラ
	 * コメント：マージしました。
	 */
	@PostMapping("/book")
	public String insertBook(@AuthenticationPrincipal LoginUserDetailsImpl user,@ModelAttribute LendingBook lendingBook) {
		//user_idをログインユーザーから取得してセット
		lendingBook.setUser_id(user.getLoginUser().getUser_id());
		
		
		
		//サービス呼び出し
		lendingService.insertBook(lendingBook);
		
		//		bookMapper.update(book);
		return "redirect:/mypage";
	}

	// 返却
	@GetMapping("/returnlist")
	public String returnlist(Model model) {
		List<LendingBook> list = bookMapper.returnSelect();
		model.addAttribute("LendingBook", list);
		return "/pages/returnlist";
	}

	@PostMapping("/returnBook")
	public String insertReturnBook(@ModelAttribute History history) {
		//		LendingBook lendingBook = new LendingBook();
		//		lendingBook.setBook_id(1);
		//		lendingBook.setUser_id(1);
		lendingService.insertReturnBook(history);
		bookMapper.returnDelete();
		return "redirect:/mypage";
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
