package com.example.demo.bootloader;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entities.Employee;
import com.example.demo.entities.EmployerDAO;
import com.example.demo.repository.EmpRepository;
import com.example.demo.repository.EmployerDaoRepo;

@Component
public class Bootloader implements CommandLineRunner {
	@Autowired
	EmpRepository empRepository;
	@Autowired
	EmployerDaoRepo daoRepo;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee(1,"ravi","teja","ravi@gmail.com");
		Employee employee1 = new Employee();
			employee1.setId(2);
			employee1.setFirstName("ganesh");
			employee1.setLastName("reddy");
			employee1.setEmailId("gani@gmail.com");
		
	List<Employee> Emps = List.of(employee,employee1);

			
		empRepository.saveAll(Emps);
		
		
		//creating Admin
		EmployerDAO dao = new EmployerDAO("ravi", "1234");
		System.out.println(dao+"cus+++++++++++*******");
		daoRepo.save(dao);
		EmployerDAO dao1 = new EmployerDAO("teja", "1234");
		System.out.println(dao+"cus+++++++++++*******");
		daoRepo.save(dao1);
		
//		printing users data
		List<EmployerDAO> users = daoRepo.findAll();
		if(users!=null) {
			users.stream().forEach(e -> System.out.println(e));
		}
		else
			System.out.println("==================empty");
		
	}

}