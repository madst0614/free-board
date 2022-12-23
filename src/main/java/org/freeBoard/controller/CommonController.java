package org.freeBoard.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class CommonController {

	@GetMapping("/customLogin")
	public void loginInput(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		log.info("error: " + error);
		log.info("logout: " + logout);

		if (error != null) {
			model.addAttribute("errorMsg", "로그인 에러! 아이디/비밀번호를 확인해주세요.");
		}

		if (logout != null) {
			model.addAttribute("logoutMsg", "로그아웃 성공!");
		}
	}

	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("Access Denied : " + auth);

		model.addAttribute("msg", "Access Denied");
	}

	@GetMapping("/customLogout")
	public void logoutGET() {
		log.info("Custom Logout");
	}
}
