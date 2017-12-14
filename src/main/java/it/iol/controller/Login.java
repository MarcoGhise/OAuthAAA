package it.iol.oauthaaa.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import it.iol.oauthaaa.security.AAAProxy;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class Login {

	private final static String AUTHORIZE_URL = "/OAuthAAA/oauth/authorize";

	@Autowired
	AAAProxy proxy;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView getUserProfile(
			@RequestParam(value = "txtUsername", defaultValue = "") String userName,
			@RequestParam(value = "txtPassword", defaultValue = "") String password,
			@RequestParam(value = "redirect_uri", defaultValue = "") String redirectUri,
			@RequestParam(value = "client_id", defaultValue = "") String clientId,
			ModelMap model, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		String authCookie = proxy.getAuthCookie(userName, password);

		/*
		 * Compongo la url
		 */
		if (!authCookie.equals("")) {

			String redirectUrl = buildRedirectAuthorizeUrl(redirectUri,
					clientId);

			System.out.println(redirectUrl);

			/*
			 * Imposto il cookie
			 */
			// create cookie and set it in response
			Cookie cookie = new Cookie("PAAA_AUTHE", authCookie);
			response.addCookie(cookie);

			return new ModelAndView(new RedirectView(redirectUrl));

		} else {
			/*
			 * User not valid
			 */
			model.addAttribute("message", "User not valid");
		}

		return new ModelAndView("login_page", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView loadLoginPage(
			@RequestParam(value = "redirect_uri", defaultValue = "") String redirectUri,
			@RequestParam(value = "client_id", defaultValue = "") String clientId,
			@CookieValue(value = "PAAA_AUTHE", defaultValue = "") String paaaCookie,
			HttpServletRequest request,
			ModelMap model) {
		
		/*
		 * Controllo se l'utente e' gia' autenticato
		 */
		if (paaaCookie.equals("")) {
			model.addAttribute("redirect_uri", redirectUri);
			model.addAttribute("client_id", clientId);
			return new ModelAndView("login_page", model);
		} else {
			String redirectUrl = buildRedirectAuthorizeUrl(redirectUri,
					clientId);
			System.out.println(redirectUrl);
			return new ModelAndView(new RedirectView(redirectUrl));
		}

	}

	protected String buildRedirectAuthorizeUrl(String redirectUri,
			String clientId) {
		Map<String, String> authorizeUrl = new HashMap<String, String>();
		authorizeUrl.put("response_type", "code");
		authorizeUrl.put("redirect_uri", redirectUri);
		authorizeUrl.put("client_id", clientId);

		StringBuilder sbAuthorizeUrl = new StringBuilder(AUTHORIZE_URL);
		sbAuthorizeUrl.append("?");

		for (Map.Entry<String, String> entry : authorizeUrl.entrySet()) {
			sbAuthorizeUrl.append(entry.getKey());
			sbAuthorizeUrl.append("=");
			sbAuthorizeUrl.append(entry.getValue());
			sbAuthorizeUrl.append("&");
		}

		return sbAuthorizeUrl.substring(0, sbAuthorizeUrl.length() - 1)
				.toString();
	}

}
