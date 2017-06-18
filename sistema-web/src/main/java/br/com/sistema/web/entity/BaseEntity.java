/**
 *
 */
package br.com.sistema.web.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import br.com.sistema.web.intercep.SecurityInterceptor;

/**
 *
 * @author edmilson.reis
 *
 */
@MappedSuperclass
@FilterDef(name = "empresaTenant", parameters = { @ParamDef(name = "id", type = "string") })
@Filter(name = "empresaTenant", condition = "EMPRESA_TENANT_ID = :id")
public class BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "empresa_tenant_id")
	private String empresaTenantId;

	@PrePersist
	@PreUpdate
	private void empresaTenantId() {
		String empresaTenantId = SecurityInterceptor.getEmpresaTenantId();
		if (empresaTenantId != null) {
			this.empresaTenantId = empresaTenantId;
		}
	}


	/**
	 * @return the empresaTenantId
	 */
	public String getEmpresaTenantId() {
		return empresaTenantId;
	}


	/**
	 * @param empresaTenantId the empresaTenantId to set
	 */
	public void setEmpresaTenantId(String empresaTenantId) {
		this.empresaTenantId = empresaTenantId;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

}
