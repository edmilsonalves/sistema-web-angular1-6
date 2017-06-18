package br.com.sistema.web.service;

import java.util.List;

import br.com.sistema.web.entity.UnidadeMedida;

public interface IUnidadeMedidaService {

	List<UnidadeMedida> findAll();

	UnidadeMedida findById(Long id);

	UnidadeMedida save(UnidadeMedida unidadeMedida);

	void delete(Long id);

}
