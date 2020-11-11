package com.kg.myapp.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kg.myapp.vo.EmpVO;

@Repository
public class EmpRepsitory {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<EmpVO> empMapper = new RowMapper<EmpVO>() {
		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmployeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("first_name"));
			emp.setLastName(rs.getString("last_name"));
			emp.setEmail(rs.getString("email"));
			emp.setPhoneNumber(rs.getString("phone_number"));
			emp.setHireDate(rs.getDate("hire_date"));
			emp.setJobId(rs.getString("job_id"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setCommissionPct(rs.getDouble("commission_pct"));
			emp.setManagerId(rs.getInt("manager_id"));
			emp.setDepartmentId(rs.getInt("department_id"));
			return emp;
		}
	};
	
	public EmpVO selectEmployee(int empId) {
		String sql="select * from employees where employee_id=?";
		return jdbcTemplate.queryForObject(sql, empMapper, empId);
	}
	
	public List<EmpVO> selectAllEmployees() {      // 문자열 전체를 가지고 오기 때문에 형태가 없음 -> selectAllEmployees()
		String sql="select * from employees";
		return jdbcTemplate.query(sql, empMapper);
	}

	
}
