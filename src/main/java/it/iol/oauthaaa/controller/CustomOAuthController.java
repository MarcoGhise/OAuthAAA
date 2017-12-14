package it.iol.oauthaaa.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("authorizationRequest")
public class CustomOAuthController {

	@RequestMapping("oauth/confirm_access_custom")
	public ModelAndView getAccessConfirmation(ModelMap model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		model.addAttribute("path", request.getContextPath());
		return new ModelAndView("confirm_access_custom", model);
	}
}
