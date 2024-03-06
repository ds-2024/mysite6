package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao; /* 연결연결이 중요 */

		
		public UserVo exeLogin(UserVo userVo) {
			
			System.out.println("UserService.exeLogin()");
			System.out.println(userVo);
			
			UserVo authUser = userDao.userSelectByIdPw(userVo);
			return authUser; 
			
		
	}

}
