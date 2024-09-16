package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Employee;
import com.example.demo.exception.CustomeException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmpRepository;

@Service
public class EmpService {
	
	@Autowired
	EmpRepository empRepository;
	
	public List<Employee> getAll() {
		List<Employee> employees = empRepository.findAll();
		return employees;
	}

	

	public Employee emp(Employee employee) {
		return empRepository.save(employee);
	}
	

	public ResponseEntity<String> deleteEmpById(Integer id) {
	Employee employee=	empRepository.findById(id).orElseThrow(()->new CustomeException("Emp not exist with id : " , id ));
		if(employee!=null) 
			empRepository.deleteById(id);
		return new ResponseEntity<>("Employee Delete Successsfully",HttpStatus.ACCEPTED);
		
	
	}
	

	public  Employee getEmp(Integer id) {
		return empRepository.findById(id).orElseThrow(()->new CustomeException("Emp not exist with id : " , id ));
	}

	public Employee updateEmp(Integer id, Employee employee) {
		Employee emp =	empRepository.findById(id).orElse(null);
		if(emp!=null) {
			
			emp.setFirstName(employee.getFirstName());
			emp.setLastName(employee.getLastName());
			emp.setEmailId(employee.getEmailId());
			
			Employee updateEmp = empRepository.save(emp);
			return updateEmp;
		}
		else
			throw new ResourceNotFoundException("Employee not found :" + id);
	}

	public Employee patchUpdate(Integer id, Employee employee) {
		Employee emp =	empRepository.findById(id).orElse(null);
		if(emp!=null) {
			
			emp.setFirstName((employee.getFirstName()!="")?employee.getFirstName():emp.getFirstName());
			emp.setLastName((employee.getLastName()!="")?employee.getLastName():emp.getLastName());
			emp.setEmailId((employee.getEmailId()!="")?employee.getEmailId():emp.getEmailId());
			
			Employee updateEmp = empRepository.save(emp);
			return updateEmp;
		}
		else
			throw new CustomeException("Emp not exist with id : " , id );
	}



	
}
