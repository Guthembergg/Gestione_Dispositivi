package com.spring_security_project.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.spring_security_project.model.Disponibilita_Dispositivo;
import com.spring_security_project.model.Tipologia_Dispositivo;
import com.spring_security_project.repository.DipendenteDAORepository;
import com.spring_security_project.repository.DispositivoDAORepository;
import com.spring_security_project.service.DipendenteService;
import com.spring_security_project.service.DispositivoService;


@Component
public class Runner implements ApplicationRunner {

	
	@Autowired DispositivoService dispositivoService;
	@Autowired DipendenteService dipendenteService;
	
    @Autowired DipendenteDAORepository dipendenteDAORepository;
    @Autowired DispositivoDAORepository dispositivoDAORepository;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		
		dipendenteService.createFakeDipendente();
		dispositivoService.createDispositivo(Tipologia_Dispositivo.SMARTPHONE, Disponibilita_Dispositivo.DISPONIBILE, null);
		dipendenteService.addDispositivotoDipendente(dispositivoDAORepository.findById(1l).get(), 2l);
		
		
		//Test con user effetuati su Postman riusulta tutto funzionante senza problemi
	}

}
