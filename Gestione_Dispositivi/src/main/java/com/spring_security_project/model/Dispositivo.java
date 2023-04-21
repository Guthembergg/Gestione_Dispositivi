package com.spring_security_project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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

@Entity
@Table(name = "dispositivi")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Dispositivo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Tipologia_Dispositivo tipo;
	private Disponibilita_Dispositivo disponibilita;
	@ManyToOne(cascade = CascadeType.MERGE)
	private Dipendente dipendente;
	public Dispositivo(Tipologia_Dispositivo tipo, Disponibilita_Dispositivo disponibilita, Dipendente dipendente) {
		super();
		this.tipo = tipo;
		this.disponibilita = disponibilita;
		this.dipendente = dipendente;
	
	}
	
	
}
