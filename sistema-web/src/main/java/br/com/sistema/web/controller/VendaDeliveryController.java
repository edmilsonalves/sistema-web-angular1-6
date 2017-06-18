package br.com.sistema.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VendaDeliveryController {

	private static String GO_VENDA_DELIVERY = "vendas/delivery/venda-delivery";

	@RequestMapping(value = "venda-delivery.html")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView(GO_VENDA_DELIVERY);
		return mav;
	}

}