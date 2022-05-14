package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.service.TasksService;
import com.example.demo.student.Employee;
import com.example.demo.student.Tasks;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tasks")
public class TasksController {
	
	public final TasksService tasksService;
	
	@Autowired
	public TasksController(TasksService tasksService) {
		this.tasksService=tasksService;
	}

	
	@GetMapping(path = "/")
	public List<Tasks> hello() {
		return tasksService.getAllTasks();	
	}
	
	@GetMapping("/{id}")
	public Tasks getbyID(@PathVariable Long id) throws Exception {
		System.out.println("this is id "+ id);	
		return tasksService.getTaskById(id);
	}
	@PostMapping("/add")
	public Tasks addSt(@RequestBody Tasks task) {
		return tasksService.add(task);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSt(@PathVariable Long id) {
		tasksService.delete(id);
	}
	@PutMapping("/update")
	public Tasks updateSt(@RequestBody Tasks task) throws Exception {
		Tasks ts=tasksService.getTaskById(task.getId());
		ts.setTitle(task.getTitle());
		ts.setDesc(task.getDesc());
		ts.setdAdded(task.getdAdded());
		ts.setdDue(task.getdDue());
		ts.setIsDone(task.getIsDone());
		ts.setIsAssigned(task.getIsAssigned());
		//ts.setEmployees(task.getEmployees());
		return tasksService.add(ts);
		
	}
}
