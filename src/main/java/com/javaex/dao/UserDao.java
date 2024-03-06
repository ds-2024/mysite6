package com.javaex.dao;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public UserVo userSelectByIdPw(UserVo userVo) {
		System.out.println("UserDao.userSelectByIdPw()");
		System.out.println(userVo);
		
		UserVo authUser = sqlSession.selectOne("user.selectByIdPw", userVo); /*"namaspace.Id"*/
		System.out.println(authUser);
		
		return authUser; /* Userxml 만들고 나서 다시 controller 까지 갖고 와서 session에 저장해줘야지 */
		
		
	}
	
	

}
