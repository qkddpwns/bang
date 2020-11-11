package com.coderby.myapp.hr.model;

public class EmpDetailVO extends EmpVO{

	private String jobTilte;
	private String managerName;
	private String departmentName;
	
	
	public String getJobTilte() {
		return jobTilte;
	}
	public void setJobTilte(String jobTilte) {
		this.jobTilte = jobTilte;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
		
	
}
