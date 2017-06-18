package br.com.sistema.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClienteController {

	private static String GO_CLIENTE_PESQUISA = "cliente/clientes";

	@RequestMapping(value = "clientes.html")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView(GO_CLIENTE_PESQUISA);
		return mav;
	}

}
