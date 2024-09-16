package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.repository.EmployerDaoRepo;
import com.example.demo.securityConfig.SecurityConfig;

//@RestController

public class AuthController {

	@Autowired
	EmployerDaoRepo daoRepo;
	
//	@Autowired
//	PasswordEncoder encoder;

//	@Autowired
//	AuthenticationManager authenticationManager;
	
	@Autowired
	SecurityConfig securityConfig;

	// withservice layer directly interacting with DB

//	@PostMapping("/register")
//	public ResponseEntity<?> createUser(@RequestBody EmployerDAO employerDAO) {
//		List<EmployerDAO> list = daoRepo.findAll();
//		boolean b = list.stream().anyMatch(e->e.getUserName()==employerDAO.getUserName());
//		if(b==false) {
//			employerDAO.setPassword(encoder.encode(employerDAO.getPassword()));
//			EmployerDAO dao = daoRepo.save(employerDAO);
//			return new ResponseEntity<EmployerDAO>(dao, HttpStatus.OK);		
//		}
//		else
//			return new ResponseEntity<String>("user already exits",HttpStatus.NOT_ACCEPTABLE);
//	
//	
//	}

//	@PostMapping("/")
//	public ResponseEntity<String> loginUser(@RequestBody EmployerDAO employerDAO) {
//
////		Authentication authentication = authenticationManager.authenticate(
////				new UsernamePasswordAuthenticationToken(employerDAO.getUserName(), employerDAO.getPassword()));
////		SecurityContextHolder.getContext().setAuthentication(authentication);
//		securityConfig.detailsService(employerDAO);
//		return new ResponseEntity<String>("User logged In Successfully",HttpStatus.ACCEPTED );
//	}
}
