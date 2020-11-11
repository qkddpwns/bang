package com.coderby.myapp.hr.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.coderby.myapp.hr.model.EmpVO;

@Service
public class EmpService implements IEmpService{
	
	@Autowired 
	@Qualifier("IEmpRepository")   //이렇게 해두면 mybatis가 들어온다.
	IEmpRepository empRepository;
	
	@Override
	public int getEmpCount() {
	return empRepository.getEmpCount();
	}
	@Override
	public int getEmpCount(int deptId) {
	return empRepository.getEmpCount(deptId);
	}
	@Override
	public List<EmpVO> getEmpList() {
	return empRepository.getEmpList();
	}
	@Override
	public EmpVO getEmpInfo(int empId) {
	return empRepository.getEmpInfo(empId);
	}
	@Override
	public void updateEmp(EmpVO emp) {
		empRepository.deleteJobHistory(emp.getEmployeeId());
		empRepository.updateEmp(emp);
	}
	@Override
	public void insertEmp(EmpVO emp) {
	empRepository.insertEmp(emp);
	}
	@Override
	public void deleteEmp(int empId) {
		empRepository.deleteJobHistory(empId);
		empRepository.updateManagers(empId);
		empRepository.deleteEmp(empId);
	}
	@Override
	public void deleteJobHistory(int empId) {
	empRepository.deleteJobHistory(empId);
	}
	@Override
	public List<Map<String, Object>> getAllDeptId() {
	return empRepository.getAllDeptId();
	}
	@Override 
	public List<Map<String, Object>> getAllJobId() { 
		 return empRepository.getAllJobId(); 
	}
	@Override
	public List<Map<String, Object>> getAllManagerId() {
	return empRepository.getAllManagerId();
	}
	@Override
	public List<EmpVO> getEmpList(int deptId) {
		return empRepository.getEmpList(deptId);
	}
	@Override
	public List<EmpVO> getEmpName(String name) {
		return empRepository.getEmpName(name);
	}
	@Override
	public int idCheck(int empId) {
		return empRepository.idCheck(empId);
	}
}
