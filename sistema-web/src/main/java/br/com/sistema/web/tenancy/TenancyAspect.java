package br.com.sistema.web.tenancy;

import javax.persistence.EntityManager;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistema.web.intercep.SecurityInterceptor;

@Aspect
@Component
@Transactional(propagation = Propagation.REQUIRED)
public class TenancyAspect {

	@Autowired
	private EntityManager manager;

	@Before("execution(* br.com.sistema.web.repository.*.*(..))")
	public void definirTenant() {
		String empresaTenantId = SecurityInterceptor.getEmpresaTenantId();
		if (empresaTenantId != null) {
			manager.unwrap(Session.class).enableFilter("empresaTenant").setParameter("id", empresaTenantId);
		}
	}

}
