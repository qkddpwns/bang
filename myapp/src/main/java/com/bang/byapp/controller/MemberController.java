package com.bang.byapp.controller;



import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bang.myapp.dao.IMemberService;
import com.bang.myapp.model.MemberVO;


@Controller
@RequestMapping(value="/member")
public class MemberController {

	@Autowired
	IMemberService memberService;
	
	@GetMapping(value="/insert")
	public void insertMember(Model model) {
		
	}
	
	@PostMapping(value="/insert")
	public String insertMember(@RequestParam MultipartFile file, MemberVO member, RedirectAttributes redirectAttributes ) {
		if(file!=null && !file.isEmpty()) {
			try {
				member.setPicture(file.getBytes());
				member.setPictureSize(file.getSize());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		memberService.insertMember(member);
		redirectAttributes.addFlashAttribute("message","회원가입완료");
		return "redirect:/login";
	}
	@PostMapping(value="/check")
	@ResponseBody
	public String idCheck(int userId) {
		return memberService.idCheck(userId)==0 ? "true" : null;
	}
	
}