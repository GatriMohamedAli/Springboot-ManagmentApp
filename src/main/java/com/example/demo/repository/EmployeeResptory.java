package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.student.Employee;


@Repository
public interface EmployeeResptory extends JpaRepository<Employee, Long> {
	
	/*@Modifying
	@Query("update Student u set u.name = ?1, u.age = ?2 where u.id = ?3")
	void updatebyQuery(String name, int age, Long userId);*/
}
