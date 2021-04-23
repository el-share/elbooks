//作成担当：大平
//作成日：2021年４月22日
//更新日：無し

package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/pages")

//mypageにアクセス
public class LoginController {
	@RequestMapping(value = "/my_page", method = RequestMethod.POST)
	private String init(Model model) {
		// HttpSessionに情報格納している
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userName = auth.getName();
		model.addAttribute("userName", userName);
		return "/pages/my_page";//ちゃんと階層を指定すること
	}

	//ログインページにアクセス
	@GetMapping("/login")
	public String Login() {
		return "pages/login.html";
	}
	
	//ログアウトページにアクセス
		@GetMapping("/logout")
		public String Logout() {
			return "pages/logout.html";
		}

}