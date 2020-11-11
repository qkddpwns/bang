package com.coderby.myapp.hr.dao;

import java.util.*;

import com.coderby.myapp.hr.model.EmpVO;

public interface IEmpService {

	int getEmpCount();
	int getEmpCount(int deptId);
	List<EmpVO> getEmpList();
	List<EmpVO> getEmpList(int deptId);
	List<EmpVO> getEmpName(String name);
	EmpVO getEmpInfo(int empId);
	void updateEmp(EmpVO emp);
	void insertEmp(EmpVO emp);
	void deleteEmp(int empId);
	void deleteJobHistory(int empId);
	List<Map<String,Object>> getAllDeptId();
	List<Map<String,Object>> getAllJobId();
	List<Map<String,Object>> getAllManagerId();
	int idCheck(int empId);
}
