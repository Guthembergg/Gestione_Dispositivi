package com.spring_security_project.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Table(name = "dipententi")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Dipendente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String username;
	private String email;
	private String nome;
	private String cognome;
	
	@JsonIgnoreProperties("dipendente")
	@OneToMany(mappedBy = "dipendente",fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
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
public void addDisp(Dispositivo d) {
	dispositivi.add(d);
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public List<Dispositivo> getDispositivi() {
	return dispositivi;
}
public void setDispositivi(List<Dispositivo> dispositivi) {
	this.dispositivi = dispositivi;
}
public Long getId() {
	return id;
}


}
