package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.TasksTakenRepository;
import com.example.demo.student.TasksTaken;

@Service
@Transactional
public class TasksTakenService {
	@Autowired
	private TasksTakenRepository tasksTakenRepo;
	
	public List<TasksTaken> hello() {
		return tasksTakenRepo.findAll();
	}

	public TasksTaken getbyId(Long id) throws Exception {
		return tasksTakenRepo.findById(id).orElseThrow(() ->new Exception("NOT FOUND")
		);
	}

	public TasksTaken add(TasksTaken tasksTaken) {
		
		return tasksTakenRepo.save(tasksTaken);
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		tasksTakenRepo.deleteById(id);
	}

	public TasksTaken update(TasksTaken tasksTaken) {
		// TODO Auto-generated method stub
		return tasksTakenRepo.save(tasksTaken);
	}

}
