package it.iol.oauthaaa.security;

import org.springframework.security.core.GrantedAuthority;

public class AAARoleClient implements GrantedAuthority{

	public String getAuthority() {
		// TODO Auto-generated method stub
		return "ROLE_CLIENT";
	}
	
	@Override
	public String toString()
	{
		return "ROLE_CLIENT";
	}
}
