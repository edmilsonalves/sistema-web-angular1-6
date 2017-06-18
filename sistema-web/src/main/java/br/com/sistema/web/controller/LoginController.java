/**
 *
 */
package br.com.sistema.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author anderson.aristides
 *
 */
@Controller
public class LoginController {

	private static String GO_LOGIN = "login";
	private static String GO_REGISTRAR = "cadastrar-se";
	private static String GO_RECUPERA_ACESSO = "recupera-acesso";

	@RequestMapping(value = "/login.html")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView(GO_LOGIN);

		return mav;
	}

	@RequestMapping(value = "/cadastrar-se.html")
	public ModelAndView registration(Model model) {
		ModelAndView mav = new ModelAndView(GO_REGISTRAR);

		return mav;
	}

	@RequestMapping(value = "recupera-acesso.html")
	public ModelAndView recuperaAcesso() {
		ModelAndView mav = new ModelAndView(GO_RECUPERA_ACESSO);

		return mav;
	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String login(Model model, String error, String logout) {
	// if (error != null)
	// model.addAttribute("error", "Your username and password is invalid.");
	//
	// if (logout != null)
	// model.addAttribute("message", "You have been logged out successfully.");
	//
	// return "login";
	// }
	//
	// @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	// public String welcome(Model model) {
	// return "welcome";
	// }
}
