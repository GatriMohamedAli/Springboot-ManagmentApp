package com.example.demo.student;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class TasksTaken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate dTaken;
	
	@ManyToOne
	private Employee employee;
	
	@ManyToOne
	private Tasks tasks;
	
	public TasksTaken() {}
	
	public TasksTaken(Long id, LocalDate dTaken) {
		this.id=id;
		this.dTaken=dTaken;
	}
	
	public TasksTaken(LocalDate dTaken) {
		this.dTaken=dTaken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getdTaken() {
		return dTaken;
	}

	public void setdTaken(LocalDate dTaken) {
		this.dTaken = dTaken;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Tasks getTasks() {
		return tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	@Override
	public String toString() {
		return "TasksTaken [id=" + id + ", dTaken=" + dTaken + ", employee=" + employee + ", tasks=" + tasks + "]";
	}
	
	
}
