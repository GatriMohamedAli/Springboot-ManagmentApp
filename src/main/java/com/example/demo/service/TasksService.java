package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TasksRepository;
import com.example.demo.student.Employee;
import com.example.demo.student.Tasks;



@Service
@Transactional
public class TasksService {
	
	@Autowired
	private TasksRepository tasksRepo;
	
	public List<Tasks> getAllTasks(){
		return tasksRepo.findAll();
	}

	public Tasks getTaskById(Long id) throws Exception {
		return tasksRepo.findById(id).orElseThrow(() ->new Exception("NOT FOUND")
		);
	}
	
	
	public Tasks add(Tasks task) {
		
		return tasksRepo.save(task);
	}

	 public void delete(Long id) {
		// TODO Auto-generated method stub
		 tasksRepo.deleteById(id);
	}

	 public Tasks update(Tasks task) {
		// TODO Auto-generated method stub
		return tasksRepo.save(task);
	}
}
