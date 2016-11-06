package com.unifilead.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.unifilead.domain.entity.Tipo;

@Transactional
public interface TipoRepository extends CrudRepository<Tipo, Integer>{
	
	@Query("select t from Tipo t")
	List<Tipo> findAllQuery();

	@Query(value = "select * from tipo", nativeQuery = true)
	List<Tipo> findAllNativeQuery();

}

