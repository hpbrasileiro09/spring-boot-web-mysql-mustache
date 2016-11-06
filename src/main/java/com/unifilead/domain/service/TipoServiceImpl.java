package com.unifilead.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifilead.domain.entity.Tipo;
import com.unifilead.domain.repository.TipoRepository;

@Service
public class TipoServiceImpl implements TipoService {

	@Autowired
	private TipoRepository repository;
	
	@Override
	public Iterable<Tipo> findAll() {
		return repository.findAll();
	}

	@Override
	public Tipo findOne(Integer id) {
		return repository.findOne(id);
	}

	@Override
	public Tipo create(String nome) {
		Tipo _tipo = new Tipo(nome);
		repository.save(_tipo);
		return _tipo;
	}

	@Override
	public Tipo update(Integer id, String nome) {
		Tipo _tipo = repository.findOne(id);
		_tipo.setNome(nome);
		repository.save(_tipo);
		return _tipo;
	}

	@Override
	public Integer destroy(Integer id) {
		Tipo _tipo = repository.findOne(id);
		repository.delete(_tipo);
		return id;
	}

}
