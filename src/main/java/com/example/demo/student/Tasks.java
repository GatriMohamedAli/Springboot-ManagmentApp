package com.example.demo.student;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="Tasks")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private String description;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate dAdded;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	private LocalDate dDue;
	
	private Integer isDone;
	
	private Integer isAssigned;
	
	@OneToMany(mappedBy = "tasks", cascade = CascadeType.ALL)
	private Collection<TasksTaken> tasksTaken;
	
	
	public Tasks() {}
	
	
	
	public Tasks(Long id, String title, String description, LocalDate dAdded, LocalDate dDue, Integer isDone,
			Integer isAssigned) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.dAdded = dAdded;
		this.dDue = dDue;
		this.isDone = isDone;
		this.isAssigned = isAssigned;
		
	}
	
	



	public Tasks(String title, String description, LocalDate dAdded, LocalDate dDue, Integer isDone, Integer isAssigned ) {
		this.title = title;
		this.description = description;
		this.dAdded = dAdded;
		this.dDue = dDue;
		this.isDone = isDone;
		this.isAssigned = isAssigned;
		
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String desc) {
		this.description = desc;
	}
	public int getIsDone() {
		return isDone;
	}
	public void setIsDone(int isDone) {
		this.isDone = isDone;
	}
	public int getIsAssigned() {
		return isAssigned;
	}
	public void setIsAssigned(int isAssigned) {
		this.isAssigned = isAssigned;
	}
	
	public LocalDate getdAdded() {
		return dAdded;
	}

	public void setdAdded(LocalDate dAdded) {
		this.dAdded = dAdded;
	}

	public LocalDate getdDue() {
		return dDue;
	}

	public void setdDue(LocalDate dDue) {
		this.dDue = dDue;
	}



	public Collection<TasksTaken> getTasksTaken() {
		return tasksTaken;
	}



	public void setTasksTaken(Collection<TasksTaken> tasksTaken) {
		this.tasksTaken = tasksTaken;
	}



	@Override
	public String toString() {
		return "Tasks [id=" + id + ", title=" + title + ", desc=" +   ", isDone=" +   " isAssigned="
				+   ", emps=]";
	}

}
