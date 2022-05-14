package com.example.demo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EmployeeService;
import com.example.demo.student.Employee;
import com.example.demo.student.User;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@GetMapping(path = {"","/getall"})
	//@RequestMapping(path = { "" , "/getall"})
	public List<Employee> hello() { 
			return employeeService.hello();			
	}
	
	@GetMapping("/{id}")
	public Employee getbyID(@PathVariable Long id) throws Exception {
		System.out.println("this is id "+ id);	
		return employeeService.getbyId(id);
	}
	@PostMapping("/add")
	public Employee addSt(@RequestBody Employee employee) {
		return employeeService.add(employee);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSt(@PathVariable Long id) {
		employeeService.delete(id);
	}
	@PutMapping("/update")
	public Employee updateSt(@RequestBody Employee employee) throws Exception {
		Employee st=employeeService.getbyId(employee.getId());
		st.setAge(employee.getAge());
		st.setEmail(employee.getEmail());
		st.setName(employee.getName());
		st.setDob(employee.getDob());
		return employeeService.add(st);
		
	}
	/*@PostMapping("/find")
	public void findlike(@RequestBody Student student){
		 studentservice.findnamelike(student);
	}*/
	

}
