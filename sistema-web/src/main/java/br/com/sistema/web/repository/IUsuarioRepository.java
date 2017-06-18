/**
 *
 */
package br.com.sistema.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sistema.web.entity.Usuario;

/**
 *
 * @author edmilson.reis
 *
 */
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>, JpaSpecificationExecutor<Usuario> {

	Usuario findByEmail(String email);

}
