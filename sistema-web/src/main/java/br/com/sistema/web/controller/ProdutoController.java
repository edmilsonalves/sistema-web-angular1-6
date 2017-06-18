package br.com.sistema.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProdutoController {

	private static String GO_PRODUTO_PESQUISA = "produto/produtos";

	@RequestMapping(value = "produtos.html")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView(GO_PRODUTO_PESQUISA);
		return mav;
	}

}
