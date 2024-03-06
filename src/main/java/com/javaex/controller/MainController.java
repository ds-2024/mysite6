package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST }) /* get post 생략시키면 둘다 디폴트상태임 */
	public String index() {
		
		System.out.println("MainController.index()");
		
		return "/main/index";
	}

}
