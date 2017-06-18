package br.com.sistema.web.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.sistema.web.entity.Role;
import br.com.sistema.web.entity.Usuario;
import br.com.sistema.web.entity.UsuarioRole;
import br.com.sistema.web.entity.UsuarioRoleId;
import br.com.sistema.web.exception.BusinessException;
import br.com.sistema.web.repository.IRoleRepository;
import br.com.sistema.web.repository.IUsuarioRepository;
import br.com.sistema.web.repository.IUsuarioRoleRepository;
import br.com.sistema.web.service.IUsuarioService;
import br.com.sistema.web.util.SUtils;

@Service
@EnableTransactionManagement
public class UsuarioServiceImpl implements IUsuarioService {

	private static final Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private IUsuarioRepository usuarioRepository;

	// @Autowired
	// private AuthenticationManager authenticationManager;

	@Autowired
	private IUsuarioRoleRepository usuarioRoleRepository;

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public Usuario salvar(Usuario usuario) throws BusinessException {
		Usuario existeUsuario = usuarioRepository.findByEmail(usuario.getEmail());

		if (!SUtils.isNull(existeUsuario)) {
			throw new BusinessException("Já existe um usuario utilizando esse email");
		}

		return usuarioRepository.save(usuario);
	}

	@Override
	public void autologin(Usuario usuario) {

		UsuarioRole usuarioRole = new UsuarioRole();
		UsuarioRoleId pk = new UsuarioRoleId();
		pk.setUsuarioId(usuario.getId());
		pk.setRoleId(1L);
		usuarioRole.setId(pk);

		usuarioRoleRepository.save(usuarioRole);
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByNome("ADMIN"));
		usuario.setRoles(roles);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Role role : usuario.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getNome()));
		}

		UserDetails userDetails = new User(usuario.getEmail(), usuario.getPassword(), grantedAuthorities);

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, usuario.getPassword(), userDetails.getAuthorities());

		// authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		if (usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			logger.debug(String.format("Auto login realizado com sucesso! ", usuario.getNome()));
		}
	}

	@Override
	public Usuario findById(Long id) throws BusinessException {
		return usuarioRepository.findOne(id);
	}

	@Override
	public Usuario recuperarAcesso(String email) throws BusinessException {

		Usuario usuario = usuarioRepository.findByEmail(email);

		if (SUtils.isNull(usuario)) {
			throw new BusinessException("Não existe um usuário com esse email, por favor verifique!");
		} else {
			usuario.setPassword(gerarSenha());
			return usuarioRepository.save(usuario);
		}
	}

	private String gerarSenha() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().substring(0,8);
	}

}
