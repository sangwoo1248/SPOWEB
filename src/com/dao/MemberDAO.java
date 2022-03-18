package com.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.MemberDTO;

public class MemberDAO {

	public void memberAdd(SqlSession s, MemberDTO dto) {
		int n = s.insert("MemberMapper.memberAdd", dto);
	}

	public MemberDTO login(SqlSession s, HashMap<String, String> map) {
		MemberDTO dto = s.selectOne("MemberMapper.login", map);
		return dto;
	}

	public MemberDTO mypage(SqlSession session, String userid) {
		MemberDTO dto = session.selectOne("MemberMapper.mypage", userid);
		return dto;
	}

	public void memberUpdate(SqlSession session, MemberDTO dto) {
		int n = session.update("MemberMapper.memberUpdate", dto);
	}

	public MemberDTO idFind(SqlSession session, MemberDTO dto) {
		MemberDTO dto2 = session.selectOne("MemberMapper.idFind", dto);
		return dto2;
	}

	public MemberDTO passFind(SqlSession session, MemberDTO dto) {
		MemberDTO dto2 = session.selectOne("MemberMapper.passFind", dto);
		return dto2;
	}

	public void withDrawal(SqlSession session, String userid) {
		int n = session.delete("MemberMapper.withDrawal", userid);
	}

}
