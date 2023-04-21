package com.spring_security_project.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring_security_project.model.Dipendente;


@Repository
public interface DipendenteDAORepository extends CrudRepository<Dipendente, Long>, PagingAndSortingRepository<Dipendente, Long>{
	public List<Dipendente> findByNome(String nome);
}
