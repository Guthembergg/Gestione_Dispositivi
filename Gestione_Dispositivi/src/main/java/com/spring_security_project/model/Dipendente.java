package com.spring_security_project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "dipententi")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Dipendente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String nome;
	private String cognome;
	@OneToMany(mappedBy = "dipendente", cascade = CascadeType.MERGE)
	private List<Dispositivo> dispositivi;
	public Dipendente(String username, String email, String nome, String cognome, List<Dispositivo> dispositivi) {
		super();
		this.username = username;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.dispositivi = dispositivi;
		this.dispositivi.forEach(e->e.setDipendente(this));
	}

}
