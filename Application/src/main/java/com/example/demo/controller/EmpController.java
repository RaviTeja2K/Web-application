package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Employee;
import com.example.demo.service.EmpService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class EmpController {
	
	@Autowired
	EmpService empService;

//	get all employees
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> employees = empService.getAll();
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

//	Delete emp by id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable Integer id) {

		return empService.deleteEmpById(id);
	}

//	create employee
	@PostMapping("/add")
	public ResponseEntity<Employee> emp(@RequestBody Employee employee) {
		Employee e = empService.emp(employee);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

//	get emp by id
	@GetMapping("/emp/{id}")
	public ResponseEntity<Employee> getEmp(@PathVariable Integer id) {
		Employee e = empService.getEmp(id);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

//	update emp
	@PutMapping("/empupdate/{id}")
	public ResponseEntity<Employee> updateEmp(@PathVariable Integer id, @RequestBody Employee employee) {
		Employee e = empService.updateEmp(id, employee);
		return new ResponseEntity<>(e, HttpStatus.OK);
	}

//	update emp
	@PatchMapping("/empPatchUpdate/{id}")
	public ResponseEntity<Employee> patchUpdate(@PathVariable Integer id, @RequestBody Employee employee) {
		Employee e = empService.patchUpdate(id, employee);
		return new ResponseEntity<>(e, HttpStatus.OK);

	}

}