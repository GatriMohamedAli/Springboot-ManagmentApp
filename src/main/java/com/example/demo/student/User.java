package com.example.demo.student;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.tools.javac.code.Attribute.Array;

@Entity
@Table(name = "users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	private Boolean isBlocked;
	
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	//@OneToOne(fetch = FetchType.LAZY, optional = false)
	//@JoinColumn(name="employee_id", nullable = false)
	@OneToOne(cascade = CascadeType.ALL)
	private Employee employee;
	//@OneToOne
	
	//private Employee employee;
	
	private String roles;

	
	public User() {}
	
	public User(String username, String password, Boolean isBlocked/*, Employee employee*/, String roles) {
		this.username = username;
		this.password = password;
		this.isBlocked = isBlocked;
		//this.employee = employee;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	public List<String> getRolesList(){
		if (this.roles.length()>0) {
			return Arrays.asList(this.roles.split(","));
		}
		return new ArrayList<String>(); 
	}
	

}
