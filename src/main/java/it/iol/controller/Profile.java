package it.iol.oauthaaa.controller;

import it.iol.oauthaaa.bean.AAAProfile;
import it.iol.oauthaaa.security.AAAProxy;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Profile {

	@Autowired
	AAAProxy proxy;

	@RequestMapping("/oauth/me")
	public @ResponseBody AAAProfile getAccessConfirmation(
			@CookieValue(value = "PAAA_AUTHE", defaultValue = "") String paaaCookie,
			HttpServletRequest request,
			Map<String, Object> model) throws Exception {

		return proxy.getUserProfile(paaaCookie);

	}

}
