package com.example.demo.student;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;




@Entity
@Table
public class Employee implements Serializable{
	
	@Id
	@SequenceGenerator(
			name = "stseq",
			sequenceName = "stseq",
			allocationSize = 1
			)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "stseq"
			)
	private long id;
	private String name;
	private String email;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate dob;
	private Integer age;
	private String division;
	private String rank;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	private Collection<TasksTaken> tasksTaken;
	
	
	
	//@OneToOne(targetEntity = Employee.class,cascade = CascadeType.ALL)
	//@JoinColumn(name="users_id", referencedColumnName = "id")
	//@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	/*@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="user_id", nullable = false)*/
	/*@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private User user;*/
	
	
	public Employee() {
		
	}
	
	
	public Employee(long id, String name, String email, LocalDate dob, 
			Integer age,String div, String rank
			) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
		this.division=div;
		this.rank=rank;
		
	}
	
	
	public Employee(String name, String email, LocalDate dob,
			Integer age, String division, String rank/*, User user*/
			) {
		super();
		this.name = name;
		this.email = email;
		this.dob = dob;
		this.age = age;
		this.division=division;
		this.rank=rank;
		//this.user=user;
		
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}


	public String getDivision() {
		return division;
	}


	public void setDivision(String division) {
		this.division = division;
	}


	public String getRank() {
		return rank;
	}


	public void setRank(String rank) {
		this.rank = rank;
	}


	


	/*public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}*/


	public Collection<TasksTaken> getTasksTaken() {
		return tasksTaken;
	}


	public void setTasksTaken(Collection<TasksTaken> tasksTaken) {
		this.tasksTaken = tasksTaken;
	}


	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age
				+ ", division=" + division + ", rank=" + rank + "]";
	}



	
	

}
