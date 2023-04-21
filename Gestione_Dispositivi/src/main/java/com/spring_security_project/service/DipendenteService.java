package com.spring_security_project.service;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Dipendente;
import com.spring_security_project.model.Dispositivo;
import com.spring_security_project.repository.DipendenteDAORepository;

@Service
public class DipendenteService {





	

		@Autowired private DipendenteDAORepository repo;
		@Autowired @Qualifier("FakeEdificio") private ObjectProvider<Dipendente> fakeDipendenteProvider;
		@Autowired @Qualifier("ParamsEdificio") private ObjectProvider<Dipendente> paramsDipendenteProvider;
		
		public void createFakeDipendente() {
			Dipendente u= fakeDipendenteProvider.getObject();
			insertDipendente(u);

		}
		
		

		
		public Dipendente insertDipendente(Dipendente u) {
			repo.save(u);
			return u;
		}
		public Dipendente createDipendente(String username, String email, String nome, String cognome, List<Dispositivo> dispositivi) {
			Dipendente u= paramsDipendenteProvider.getObject( username,  email,  cognome,  dispositivi); 
			insertDipendente(u);
			return u;
		}

		public Dipendente findDipendenteById(Long id) {
			return repo.findById(id).get();
		}
		
		public List<Dipendente> findAllDipendente() {
			return (List<Dipendente>) repo.findAll();
		}
		
		public String removeDipendente(Long id) {
			repo.deleteById(id);
			return "User Deleted!!!";
		}
		public Dipendente updateDipendente(Dipendente u) {
			repo.save(u);
			return u;
		}
	}


