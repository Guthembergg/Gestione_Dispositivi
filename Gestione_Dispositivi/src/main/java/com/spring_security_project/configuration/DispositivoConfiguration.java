package com.spring_security_project.configuration;

import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
import com.spring_security_project.model.Dipendente;
import com.spring_security_project.model.Disponibilita_Dispositivo;
import com.spring_security_project.model.Dispositivo;
import com.spring_security_project.model.Tipologia_Dispositivo;

@Configuration
@PropertySource("classpath:application.properties")
public class DispositivoConfiguration {

	@Bean("CustomDispositivo")
	@Scope("prototype")
	public Dispositivo customDispositivo() {
		return new Dispositivo();
	}

	@Bean("ParamsDispositivo")
	@Scope("prototype")
	public Dispositivo paramsDispositivo(Tipologia_Dispositivo tipo, Disponibilita_Dispositivo disponibilita, Dipendente dipendente) {
		return new Dispositivo(tipo, disponibilita, dipendente);
	}


}
