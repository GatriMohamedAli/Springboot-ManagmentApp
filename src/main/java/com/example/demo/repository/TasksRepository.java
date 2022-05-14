package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.student.Tasks;

public interface TasksRepository extends JpaRepository<Tasks, Long> {

}
