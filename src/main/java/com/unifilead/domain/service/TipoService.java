package com.unifilead.domain.service;

import com.unifilead.domain.entity.Tipo;

public interface TipoService {

	Iterable<Tipo> findAll();
	
	Tipo findOne(Integer id);

	Tipo create(String nome);

	Tipo update(Integer id, String nome);
	
	Integer destroy(Integer id);
	
}
