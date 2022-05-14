package com.example.demo.configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmployeeResptory;
import com.example.demo.repository.TasksRepository;
import com.example.demo.repository.TasksTakenRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.student.Employee;
import com.example.demo.student.Tasks;
import com.example.demo.student.TasksTaken;
import com.example.demo.student.User;

@Service
public class DbInit implements CommandLineRunner {
	private EmployeeResptory empRepo;
	
	private PasswordEncoder passwordEncoder;
	private UserRepository userRepo;
	private TasksRepository tasksRepo;
	private TasksTakenRepository tasksTakenRepo;


	public DbInit(EmployeeResptory empRepo, PasswordEncoder passwordEncoder, UserRepository userRepo,
			TasksRepository tasksRepo, TasksTakenRepository tasksTakenRepo) {
		this.empRepo = empRepo;
		this.passwordEncoder = passwordEncoder;
		this.userRepo = userRepo;
		this.tasksRepo = tasksRepo;
		this.tasksTakenRepo = tasksTakenRepo;
	}


	@Override
	public void run(String... args) throws Exception {
		/*User u1=userRepo.getById((long) 3);
		User u2=userRepo.getById((long) 4);
		userRepo.delete(u1);
		userRepo.delete(u2);*/
		empRepo.deleteAll();
		userRepo.deleteAll();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date = "16/08/1998";
		List<Tasks> tasks=new ArrayList<>();
		Employee emp1=new Employee("daly","daly@gmail.com",LocalDate.parse(date,formatter),22,"RH","HEAD");
		Employee emp2=new Employee("daly2","daly@gmail.com2",LocalDate.parse(date,formatter),22,"RH","HEAD");
		//empRepo.save(emp1);
		//empRepo.save(emp2);
		
		User daly=new User("daly",passwordEncoder.encode("daly"),false,"Admin");
		User d2=new User("di",passwordEncoder.encode("dali"),false,"Admin");
		daly.setEmployee(emp1);
		d2.setEmployee(emp2);
		//emp1.setTasksTaken(null);
		//emp2.setTasksTaken(null);
		
		userRepo.save(daly);
		userRepo.save(d2);
		
		//emp1.setUser(daly);
		//emp2.setUser(d2);
		
		Tasks task1=new Tasks("Tache","Tache11",LocalDate.parse(date,formatter),LocalDate.parse(date,formatter),0,0);
		Tasks task2=new Tasks("Tache2","Tache22",LocalDate.parse(date,formatter),LocalDate.parse(date,formatter),0,0);
		//task1.setTasksTaken(null);
		//task2.setTasksTaken(null);
		tasksRepo.save(task1);
		tasksRepo.save(task2);
		
		TasksTaken tt1=new TasksTaken(LocalDate.parse(date,formatter));
		TasksTaken tt2=new TasksTaken(LocalDate.parse(date,formatter));
		tasksTakenRepo.save(tt1);
		tasksTakenRepo.save(tt2);
		tt1.setEmployee(emp1);
		tt1.setTasks(task1);
		tt2.setEmployee(emp1);
		tt2.setTasks(task2);
		
		
	}

}
