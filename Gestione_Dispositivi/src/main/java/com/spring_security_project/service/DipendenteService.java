package com.spring_security_project.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring_security_project.model.Dipendente;
import com.spring_security_project.model.Disponibilita_Dispositivo;
import com.spring_security_project.model.Dispositivo;
import com.spring_security_project.repository.DipendenteDAORepository;
import com.spring_security_project.repository.DispositivoDAORepository;

@Service
public class DipendenteService {

	@Autowired
	private DispositivoDAORepository repoD;
	@Autowired
	private DipendenteDAORepository repo;
	@Autowired
	@Qualifier("FakeDipendente")
	private ObjectProvider<Dipendente> fakeDipendenteProvider;
	@Autowired
	@Qualifier("ParamsDipendente")
	private ObjectProvider<Dipendente> paramsDipendenteProvider;

	public void createFakeDipendente() {
		Dipendente u = fakeDipendenteProvider.getObject();
		insertDipendente(u);

	}

	public String addDispositivotoDipendente(Dispositivo d, Long id) {
		Long idD = d.getId();
		Dipendente u = findDipendenteById(id);
		if (!repoD.findById(idD).isPresent()) {
			System.out.println("dispositive inexistant");
			return "dispositive inexistant";
		} else if (u == null) {
			System.out.println("no user found with that id");

			return "no user found with that id";
		} else if (d.getDisponibilita() != Disponibilita_Dispositivo.DISPONIBILE) {
			System.out.println("d not available");
			return "Dispositive not available";
		} else {
			d.setDisponibilita(Disponibilita_Dispositivo.ASSEGNATO);
			u.addDisp(d);
			d.setDipendente(u);
			repo.save(u);
			System.out.println("dispositive added to user");
			return "dispositive added to user";
		}

	}

	public Dipendente insertDipendente(Dipendente u) {
		repo.save(u);
		return u;
	}

	public Dipendente createDipendente(String username, String email, String nome, String cognome,
			List<Dispositivo> dispositivi) {
		Dipendente u = paramsDipendenteProvider.getObject(username, email, cognome, dispositivi);
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
