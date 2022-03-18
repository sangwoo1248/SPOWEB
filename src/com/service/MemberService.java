package com.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MemberDAO;
import com.dto.CartDTO;
import com.dto.MemberDTO;

public class MemberService {

	public void memberAdd(MemberDTO dto) {
		SqlSession s = MySqlSessionFactory.getSession();
		MemberDAO dao = new MemberDAO();
		try {
			dao.memberAdd(s,dto);
			s.commit();
		}
		finally {
			s.close();
		}
	}

	public MemberDTO login(HashMap<String, String> map) {
		SqlSession s = MySqlSessionFactory.getSession();
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = null;
		try {
			dto = dao.login(s, map);
			s.commit();
		}
		finally {
			s.close();
		}
		return dto;
	}

	public MemberDTO mypage(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDTO dto =null;
		MemberDAO dao =new MemberDAO();
		try {
			dto = dao.mypage(session,userid);
		}finally {
			session.close();
		}
		return dto;
	}

	public void memberUpdate(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDAO dao =new MemberDAO();
		try {
			dao.memberUpdate(session, dto);
			session.commit();
		}
		finally {
			session.close();
		}
		
	}

	public MemberDTO idFind(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDAO dao =new MemberDAO();
		try {
			dto = dao.idFind(session, dto);
		}
		finally {
			session.close();
		}
		return dto;
	}

	public MemberDTO passFind(MemberDTO dto) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDAO dao =new MemberDAO();
		try {
			dto = dao.passFind(session, dto);
		}
		finally {
			session.close();
		}
		return dto;
	}

	public void withDrawal(String userid) {
		SqlSession session = MySqlSessionFactory.getSession();
		MemberDAO dao = new MemberDAO();
		try {
			dao.withDrawal(session,userid);
			//session.commit();
		}
		finally {
			session.close();
		}
		
	}
}
