package com.spring_security_project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "dispositivi")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.STRING)
	private Tipologia_Dispositivo tipo;
	@Enumerated(EnumType.STRING)

	private Disponibilita_Dispositivo disponibilita;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Dipendente dipendente;
	public Dispositivo(Tipologia_Dispositivo tipo, Disponibilita_Dispositivo disponibilita, Dipendente dipendente) {
		super();
		this.tipo = tipo;
		this.disponibilita = disponibilita;
		this.dipendente = dipendente;
	
	}
	public Tipologia_Dispositivo getTipo() {
		return tipo;
	}
	public void setTipo(Tipologia_Dispositivo tipo) {
		this.tipo = tipo;
	}
	public Disponibilita_Dispositivo getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(Disponibilita_Dispositivo disponibilita) {
		this.disponibilita = disponibilita;
	}
	public Dipendente getDipendente() {
		return dipendente;
	}
	public void setDipendente(Dipendente dipendente) {
		this.dipendente = dipendente;
	}
	public Long getId() {
		return id;
	}
	
	
}
