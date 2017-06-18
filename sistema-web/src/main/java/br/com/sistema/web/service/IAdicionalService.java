package br.com.sistema.web.service;

import java.util.List;

import br.com.sistema.web.entity.Adicional;

public interface IAdicionalService {

	List<Adicional> findAll();

	Adicional findById(Long id);

	Adicional save(Adicional categoria);

	void delete(Long adicionalId, Long produtoId);

}
