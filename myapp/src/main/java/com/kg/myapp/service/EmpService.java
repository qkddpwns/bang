package com.kg.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.myapp.dao.EmpRepsitory;
import com.kg.myapp.vo.EmpVO;


public class EmpService {
	
	@Autowired
	EmpRepsitory empRepsitory;
	
	public EmpVO selectEmployee(int empId) {
		return empRepsitory.selectEmployee(empId);
	}
	
	public List<EmpVO> selectAllEmployee() {
		return empRepsitory.selectAllEmployees();
	}
	
}
