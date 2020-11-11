package com.kg.myapp.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderby.myapp.hr.dao.IEmpService;
import com.coderby.myapp.hr.model.EmpDetailVO;
import com.coderby.myapp.hr.model.EmpVO;
import com.coderby.myapp.util.EmpValidator;

@Controller    //요청과 응답처리 
public class EmpController {
	
	@Autowired
	IEmpService empService;
	
	@GetMapping(value="/emp") //GET방식만을 받는다.
	public String mainPage(Model model) {
		model.addAttribute("message","Hello! Welcom to EmpApp.");
		return "home";
	}
	
	@GetMapping(value="/emp/count")
	public String empCount(@RequestParam(value="deptId", required=false, defaultValue="0" )int deptId, Model model) {  //@RequestParam은 
		if(deptId==0) {
			model.addAttribute("count",empService.getEmpCount());	
		}else {
			model.addAttribute("count",empService.getEmpCount(deptId));	
		}
		return "emp/count";
	}
	
	@GetMapping(value="/emp/list")
	public void empList(Model model) {
		model.addAttribute("empList", empService.getEmpList());
	}
	
	@GetMapping(value="/emp/{employeeId}")
	public String empView(@PathVariable int employeeId, Model model) {    //@PathVariable은 경로를 변수로 생성하겠다 라는 의미
		model.addAttribute("emp",(EmpDetailVO)empService.getEmpInfo(employeeId));
		return "emp/view";
	}
	
	@GetMapping(value="/emp/viewlist")
	public String empViewlist(int deptId, Model model) {
		model.addAttribute("empList",empService.getEmpList(deptId));
		return "emp/list";
	}
	
	@GetMapping(value="/emp/namelist")
	public String empName(String name, Model model) {
		name ="%"+name+"%";
		model.addAttribute("empList",empService.getEmpName(name));
		return "emp/list";
	}


	@GetMapping(value="/emp/update/{empId}")
	public String empUpdate(@PathVariable int empId, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empId));
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("manList", empService.getAllManagerId());
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("message","update");
		return "emp/insert";
	}
	
	@PostMapping(value="/emp/update")
	public String empUpdate(EmpVO emp) {
		empService.updateEmp(emp);
		return "redirect:/emp/"+emp.getEmployeeId();
	}
	
	/*
	 * @GetMapping(value="/emp/delete") public String empDelete(int empId, Model
	 * model) { model.addAttribute("emp", empService.getEmpInfo(empId)); return
	 * "emp/delete"; }
	 * 
	 * @PostMapping(value="/emp/delete") public String empDelete(Model model, int
	 * empId) { empService.deleteEmp(empId); return "redirect:/emp/list"; }
	 */
	@ExceptionHandler(RuntimeException.class)
	public String runtimeException(Exception e, HttpServletRequest request, Model model) {
		model.addAttribute("url", request.getRequestURI());
		model.addAttribute("exception", e);
		return "error/runtime";
	}
	
	@PostMapping(value="/emp/insert")
	public String insertEmp(@ModelAttribute("emp") @Valid EmpVO emp, BindingResult result, Model model, @RequestParam MultipartFile file, RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("jobList",empService.getAllJobId());
			model.addAttribute("manList",empService.getAllManagerId());
			model.addAttribute("deptList",empService.getAllDeptId());
			model.addAttribute("message","insert");
			return "emp/insert";
		}
		if((file != null) && (!file.isEmpty())) {
			try {
				emp.setEmpPic(file.getBytes());
				emp.setFileSize(file.getSize());
			} catch (IOException e) {
				e.printStackTrace();
				redirectAttributes.addFlashAttribute("message", e.getMessage());
				redirectAttributes.addFlashAttribute("exception", e);
				throw new RuntimeException();
			}
		}
		empService.insertEmp(emp);
		redirectAttributes.addFlashAttribute("message", "회원 저장 완료");
		return "redirect:/emp/list";
	}

	@GetMapping(value="/emp/insert")
	public String insertEmp(Model model) {
		model.addAttribute("emp", new EmpVO());
		model.addAttribute("jobList",empService.getAllJobId());
		model.addAttribute("manList",empService.getAllManagerId());
		model.addAttribute("deptList",empService.getAllDeptId());
		model.addAttribute("message","insert");
		return "emp/insert";
	}
	
	@GetMapping("/emp/pic/{empId}")
	public ResponseEntity<byte[]> getPicture(@PathVariable int empId){
		EmpVO emp = empService.getEmpInfo(empId);
		final HttpHeaders headers = new HttpHeaders();
		if(emp.getEmpPic() != null) {
			headers.setContentType(new MediaType("image","jpg"));
			headers.setContentDispositionFormData("attachment", "프로필사진");
			headers.setContentLength(emp.getFileSize());
			return new ResponseEntity<byte[]>(emp.getEmpPic(), headers, HttpStatus.OK);
		}else {
			return new ResponseEntity<byte[]>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(value="/emp/check")
	@ResponseBody
	public String idCheck(int empId) {
		return empService.idCheck(empId)==0 ? "true" : null;
	}
	
}