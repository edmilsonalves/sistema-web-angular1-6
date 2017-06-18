package br.com.sistema.web.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.sistema.web.entity.Cliente;

public class ClienteSpecification implements Specification<Cliente> {

	private String nome;

	public ClienteSpecification(String nomeI) {
		this.nome = nomeI;
	}

	@Override
	public Predicate toPredicate(Root<Cliente> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		Predicate p = cb.conjunction();
		if (nome != null) {
			p.getExpressions().add(cb.like(root.get("nome"), "%" + nome + "%"));
		}
		return p;
	}

}
