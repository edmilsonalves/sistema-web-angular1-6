package br.com.sistema.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AcessoNegadoController {

	private static String GO_ACESSO_NEGADO = "acesso-negado";

	@RequestMapping(value = "acesso-negado.html")
	public ModelAndView acessoNegado() {
		ModelAndView mav = new ModelAndView(GO_ACESSO_NEGADO);
		return mav;
	}

}
