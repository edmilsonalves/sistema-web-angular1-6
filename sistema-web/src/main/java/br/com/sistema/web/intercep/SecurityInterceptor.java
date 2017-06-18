package br.com.sistema.web.intercep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.sistema.web.entity.Role;
import br.com.sistema.web.entity.Usuario;
import br.com.sistema.web.repository.IUsuarioRepository;
import br.com.sistema.web.util.SUtils;

@Component
public class SecurityInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private IUsuarioRepository usuarioService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Usuario usuario = null;

		String empresaTenantId = (String) request.getSession().getAttribute("empresaTenantId");

		if (SUtils.isNullOrEmpty(empresaTenantId)) {
			String user = SUtils.getUser();
			if (!SUtils.isNull(usuarioService) && !"anonymousUser".equals(user)) {
				usuario = usuarioService.findByEmail(user);
				if (!SUtils.isNull(usuario)) {

					String roleUsuarioLogado = null;
					if(!SUtils.isNullOrEmpty(usuario.getRoles())){
						Role role = new Role();
						role.setNome("ADMIN");

						if(usuario.getRoles().contains(role)){
							roleUsuarioLogado = "Administrador";
						}else{
							roleUsuarioLogado = "Usuario";
						}
					}

					empresaTenantId = usuario.getEmpresaTenantId();
					request.getSession().setAttribute("empresaTenantId", usuario.getEmpresaTenantId());
					request.getSession().setAttribute("usuarioLogado", usuario.getNome());
					request.getSession().setAttribute("roleUsuarioLogado", roleUsuarioLogado);
					request.getSession().setAttribute("empresaLogada", usuario.getEmpresa().getDescSigla());
					request.getSession().setAttribute("empresaLogadaSigla", usuario.getEmpresa().getSigla());
				}
				// if (SUtils.isNullOrEmpty(empresaTenantId)) {
				// throw new Exception(
				// "Erro ao consultar EMPRESA_TENANT_ID, informe esse erro para
				// edmilsonalvesdosreis@gmail.com, copie e cole o erro no
				// assunto do email ");
				// }
			}

		}
		request.setAttribute("EMPRESA_TENANT_ID", empresaTenantId);

		return true;
	}

	public static String getEmpresaTenantId() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();

		if (requestAttributes != null) {
			return (String) requestAttributes.getAttribute("EMPRESA_TENANT_ID", RequestAttributes.SCOPE_REQUEST);
		}

		return null;
	}

}