package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Dipendente;
import com.spring_security_project.model.Disponibilita_Dispositivo;
import com.spring_security_project.model.Dispositivo;
import com.spring_security_project.model.Tipologia_Dispositivo;
import com.spring_security_project.repository.DipendenteDAORepository;
import com.spring_security_project.repository.DispositivoDAORepository;

@Service
public class DispositivoService {





	

		@Autowired private DispositivoDAORepository repo;
		@Autowired @Qualifier("ParamsDispositivo") private ObjectProvider<Dispositivo> paramsDispositivoProvider;
		

		
		public Dispositivo insertDispositivo(Dispositivo u) {
			repo.save(u);
			return u;
		}
		public Dispositivo createDispositivo(Tipologia_Dispositivo tipo, Disponibilita_Dispositivo disponibilita, Dipendente dipendente) {
			Dispositivo u= paramsDispositivoProvider.getObject( tipo,  disponibilita,  dipendente); 
			insertDispositivo(u);
			return u;
		}

		public Dispositivo findDispositivoById(Long id) {
			return repo.findById(id).get();
		}
		
		public List<Dispositivo> findAllDispositivo() {
			return (List<Dispositivo>) repo.findAll();
		}
		
		public String removeDispositivo(Long id) {
			repo.deleteById(id);
			return "Dispositivo Deleted!!!";
		}
		public Dispositivo updateDispositivo(Dispositivo u) {
			repo.save(u);
			return u;
		}
	}


