package com.spring_security_project.configuration;
import java.util.List;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;


import com.github.javafaker.Faker;
import com.spring_security_project.model.Dipendente;
import com.spring_security_project.model.Dispositivo;
@Configuration
@PropertySource("classpath:application.properties")
public class DipendenteConfiguration {



		@Bean("CustomDipendente")
		@Scope("prototype")
		public Dipendente customDipendente() {
			return new Dipendente();
		}

		@Bean("ParamsDipendente")
		@Scope("prototype")
		public Dipendente paramsDipendente(String username, String email, String nome, String cognome, List<Dispositivo> dispositivi) {
			return new Dipendente(username, email, nome,  cognome,
					 dispositivi);
		}

		@Bean("FakeDipendente")
		@Scope("prototype")
		public Dipendente fakeDipendente() {
			Dipendente u = new Dipendente();
			Faker fake = new Faker(new Locale("it-IT"));
			u.setNome(fake.name().firstName());
			u.setCognome(fake.name().lastName());
			u.setEmail(fake.internet().emailAddress());
			u.setUsername(fake.name().username());
		
			return u;
		}
	}


