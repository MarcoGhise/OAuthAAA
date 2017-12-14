package it.iol.oauthaaa.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;

public class AAAClientCredential extends ClientCredentialsTokenEndpointFilter {

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {

		/*
		 * Leggo il cookie AAA
		 */
		Cookie[] cookies = request.getCookies();
		
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken("mysupplycompany", "mycompanykey");

		Authentication auth =  this.getAuthenticationManager().authenticate(authRequest);
		
		/*
		 * Abilita o meno l'utente se esiste il cookie
		 */
		/*
		for (Cookie cookie : cookies)
		{
			if (cookie.getName().equals("PAAA_AUTHE"))
				return auth;
		}
		
		throw new AuthenticationCredentialsNotFoundException("Cookie not found");
		 */
		return auth;
	}
	
	@Override
	protected boolean requiresAuthentication(HttpServletRequest request, HttpServletResponse response) {
		
		return true;
	}
}
