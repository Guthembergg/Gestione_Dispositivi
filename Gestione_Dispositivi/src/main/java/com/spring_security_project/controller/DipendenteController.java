package com.spring_security_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_project.model.Dipendente;
import com.spring_security_project.service.DipendenteService;



@RestController
@RequestMapping("/dipendente")
public class DipendenteController {
@Autowired DipendenteService userService;
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<List<Dipendente>>(userService.findAllDipendente(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id){
		return new ResponseEntity<Dipendente>(userService.findDipendenteById(id), HttpStatus.OK);
//		try {
//			return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
//		} catch (EntityNotFoundException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		}
	}
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody Dipendente user) {
		return new ResponseEntity<Dipendente>(userService.insertDipendente(user), HttpStatus.CREATED);
//		try {
//			return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		} 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return new ResponseEntity<String>(userService.removeDipendente(id), HttpStatus.OK);
//		try {
//			return new ResponseEntity<String>(userService.removeUser(id), HttpStatus.OK);
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody Dipendente user) {
		return new ResponseEntity<Dipendente>(userService.updateDipendente(user), HttpStatus.CREATED);
//		try {
//			return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.CREATED);
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		} 
	}
}
