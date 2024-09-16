package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.EmployerDAO;

@Repository
public interface EmployerDaoRepo extends JpaRepository<EmployerDAO, Integer> {
	
	List<EmployerDAO> findByUserName(String userName);
}
