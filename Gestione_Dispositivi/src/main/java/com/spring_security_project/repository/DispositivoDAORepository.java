package com.spring_security_project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring_security_project.model.Dispositivo;


@Repository
public interface DispositivoDAORepository extends CrudRepository<Dispositivo, Long>, PagingAndSortingRepository<Dispositivo, Long>{

}
