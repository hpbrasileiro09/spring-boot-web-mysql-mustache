package com.unifilead.domain.resource;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.unifilead.domain.entity.Tipo;
import com.unifilead.domain.service.TipoService;

@Controller
public class TipoResource {

	@Autowired
	private TipoService tipoService;

	public TipoResource(TipoService tipoService) {
		this.tipoService = tipoService;
	}
	
	@RequestMapping(path = "/tipo", method = RequestMethod.GET)
	public String findAll(Map<String, Object> model) 
	{
		model.put("tipos", tipoService.findAll());		
		return "tipo-list";
	}

	@RequestMapping(path = "/tipo/{id}", method = RequestMethod.GET)
	public Tipo findOne(@RequestParam(name = "id") Integer id)
	{
		return tipoService.findOne(id);
	}

	@RequestMapping(path = "/tipo/new", method = RequestMethod.GET)
	public String novoTipo(Map<String, Object> model)
	{
		return "tipo-new";
	}

	@RequestMapping(path = "/tipo/edit/{id}", method = RequestMethod.GET)
	public String update(@PathVariable Integer id, Map<String, Object> model)
	{
		Tipo _tipo = tipoService.findOne(id);
		model.put("tipo", _tipo);
		return "tipo-edit";
	}

	@RequestMapping(path = "/tipo/delete/{id}", method = RequestMethod.GET)
	public String fdelete(@PathVariable Integer id, Map<String, Object> model)
	{
		Tipo _tipo = tipoService.findOne(id);
		model.put("tipo", _tipo);
		return "tipo-delete";
	}

	@RequestMapping(path = "/tipo", method = RequestMethod.POST)
	public String create(@RequestParam(name = "nome") String nome)
	{
		try {
			tipoService.create(nome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/tipo";
	}

	@RequestMapping(path = "/tipo/{id}", method = RequestMethod.POST)
	public String update(@PathVariable Integer id, String nome)
	{
		try {
			tipoService.update(id, nome);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/tipo";
	}

	@RequestMapping(path = "/tipo/remove", method = RequestMethod.POST)
	public String delete(@RequestParam(name = "id") Integer id)
	{
		try {
			tipoService.destroy(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/tipo";
	}
	
}
