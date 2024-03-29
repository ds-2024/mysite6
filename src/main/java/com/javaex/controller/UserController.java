package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//로그인
	@RequestMapping(value = "/user/login",  method = {RequestMethod.GET, RequestMethod.POST})
	public String login(HttpSession session,@ModelAttribute UserVo userVo) {
		
		System.out.println("UserController.login()");
		
		UserVo authUser = userService.exeLogin(userVo);
		System.out.println(authUser);
		
		
		if(authUser == null) {
			return "redirect:/user/loginform";
			
		}else {
		//세션에 올린다
		session.setAttribute("authUser", authUser); // HttpSession session 넣어줘야 세션 작동하지 > 그리고 임폴트!
		return "redirect:/main";
		}
	}
	//로그인폼
	@RequestMapping(value = "/user/loginform",  method = {RequestMethod.GET, RequestMethod.POST})
	public String loginform() {
		
		System.out.println("UserController.loginform()");
		
		return "user/loginForm"; /* 대소문자 구분! 무엇을 연결했는지 명확하게 인지하자 */
		
	}

}
