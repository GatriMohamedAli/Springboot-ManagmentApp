package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmployeeResptory;
import com.example.demo.repository.UserRepository;
import com.example.demo.student.Employee;
import com.example.demo.student.User;

@Service
@Transactional
public class EmployeeService {
	
	@Autowired
	private EmployeeResptory empRep;
	
	public List<Employee> hello() {
		return empRep.findAll();
	}

	public Employee getbyId(Long id) throws Exception {
		return empRep.findById(id).orElseThrow(() ->new Exception("NOT FOUND")
		);
	}

	public Employee add(Employee employee) {
		
		return empRep.save(employee);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		empRep.deleteById(id);
	}

	public Employee update(Employee employee) {
		// TODO Auto-generated method stub
		return empRep.save(employee);
	}
	
	/*public void findnamelike(Student student){
		 empRep.updatebyQuery(student.getName(), student.getAge(), student.getId());
	}*/
	
}
