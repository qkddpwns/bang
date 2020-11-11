package com.bang.myapp.dao;

import com.bang.myapp.model.MemberVO;

public interface IMemberService {

	void insertMember(MemberVO member);
	String getPassword(String userid);
	MemberVO getMember(String userid);
	int idCheck(int userId);
}
