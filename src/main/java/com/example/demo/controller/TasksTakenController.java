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
import com.example.demo.service.TasksTakenService;
import com.example.demo.student.Tasks;
import com.example.demo.student.TasksTaken;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/taskstaken")
public class TasksTakenController {
	
	public final TasksTakenService tasksService;
	
	@Autowired
	public TasksTakenController(TasksTakenService tasksService) {
		this.tasksService=tasksService;
	}

	
	@GetMapping(path = "/")
	public List<TasksTaken> hello() {
		return tasksService.hello();	
	}
	
	@GetMapping("/{id}")
	public TasksTaken getbyID(@PathVariable Long id) throws Exception {
		System.out.println("this is id "+ id);	
		return tasksService.getbyId(id);
	}
	@PostMapping("/add")
	public TasksTaken addSt(@RequestBody TasksTaken task) {
		return tasksService.add(task);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteSt(@PathVariable Long id) {
		tasksService.delete(id);
	}
	@PutMapping("/update")
	public TasksTaken updateSt(@RequestBody TasksTaken task) throws Exception {
		return null;
		/*Tasks ts=tasksService.getTaskById(task.getId());
		ts.setTitle(task.getTitle());
		ts.setDesc(task.getDesc());
		ts.setdAdded(task.getdAdded());
		ts.setdDue(task.getdDue());
		ts.setIsDone(task.getIsDone());
		ts.setIsAssigned(task.getIsAssigned());
		//ts.setEmployees(task.getEmployees());
		return tasksService.add(ts);*/
		
	}

}
