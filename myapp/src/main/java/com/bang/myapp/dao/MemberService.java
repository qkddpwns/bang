package com.bang.myapp.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.bang.myapp.model.MemberVO;

@Service
public class MemberService implements IMemberService{

	@Autowired
	IMemberRepository memberRepository;
	
	@Autowired
	BCryptPasswordEncoder bpe;
	
	@Override
	public void insertMember(MemberVO member) {
		member.setPassWord(bpe.encode(member.getPassWord()));
		memberRepository.insertMember(member);
		
	}

	@Override
	public String getPassword(String userid) {
		return memberRepository.getPassword(userid);
	}

	@Override
	public MemberVO getMember(String userid) {
		return memberRepository.getMember(userid);
	}

	@Override
	public int idCheck(int userId) {
		return memberRepository.idCheck(userId);
	}
	

	
	
	
}
