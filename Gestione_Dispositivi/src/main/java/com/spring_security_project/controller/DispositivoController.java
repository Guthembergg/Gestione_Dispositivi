package com.spring_security_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_security_project.model.Dipendente;
import com.spring_security_project.model.Dispositivo;
import com.spring_security_project.service.DipendenteService;
import com.spring_security_project.service.DispositivoService;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/dispositivo")
public class DispositivoController {
	
@Autowired DispositivoService userService;
	
@PreAuthorize(" hasRole('MODERATOR') or hasRole('ADMIN')")

@GetMapping
	public ResponseEntity<?> getAll(){
		return new ResponseEntity<List<Dispositivo>>(userService.findAllDispositivo(), HttpStatus.OK);
	}
@PreAuthorize("isAuthenticated()")
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable Long id){
		return new ResponseEntity<Dispositivo>(userService.findDispositivoById(id), HttpStatus.OK);
//		try {
//			return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
//		} catch (EntityNotFoundException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		}
	}
@PreAuthorize(" hasRole('ADMIN')")

	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody Dispositivo user) {
		return new ResponseEntity<Dispositivo>(userService.insertDispositivo(user), HttpStatus.CREATED);
//		try {
//			return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		} catch (Exception e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
//		} 
	}
@PreAuthorize("hasRole('ADMIN')")

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		return new ResponseEntity<String>(userService.removeDispositivo(id), HttpStatus.OK);
//		try {
//			return new ResponseEntity<String>(userService.removeUser(id), HttpStatus.OK);
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		}
	}
@PreAuthorize("hasRole('ADMIN')")

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@RequestBody Dispositivo user) {
		return new ResponseEntity<Dispositivo>(userService.updateDispositivo(user), HttpStatus.CREATED);
//		try {
//			return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.CREATED);
//		} catch (EntityExistsException e) {
//			return new ResponseEntity<String>(e.getMessage(), HttpStatus.FOUND);
//		} 
	}
}
