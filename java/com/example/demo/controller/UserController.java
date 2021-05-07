package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.User;
import com.example.demo.repository.DisplayMapper;
import com.example.demo.repository.InsertMapper;
import com.example.demo.repository.UpdateMapper;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	DisplayMapper displayMapper;
	@Autowired
	InsertMapper insertMapper;
	@Autowired
	UpdateMapper updateMapper;

	// ユーザーの一覧表示
	@GetMapping("/list")
	public String users(@ModelAttribute User user,Model model) {
		model.addAttribute("userList",displayMapper.findUser());
		return "pages/user_list";
	}

	// ユーザーの登録処理
	@PostMapping("/add")
	public String userAdd(@ModelAttribute User user,@RequestParam String mail) {
		insertMapper.insertUser(user);
		return "redirect:/user/list";
	}

	// ユーザーの編集処理
	@PostMapping("/edit")
	public String userEdit(@ModelAttribute User user,@RequestParam int userId) {
		user.setUser_id(userId);
		updateMapper.updateUser(user);
		return "redirect:/user/list";
	}

	// ユーザーの削除処理
	@PostMapping("/delete")
	public String userDrop(@ModelAttribute User user,@RequestParam int userId) {
		updateMapper.deleteUser(userId);
		return "redirect:/user/list";
	}

}