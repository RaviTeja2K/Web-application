package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "employerDAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployerDAO {


	@Id
	private String userName;
	private String password;
	
	
}