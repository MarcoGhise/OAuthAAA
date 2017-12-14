package it.iol.oauthaaa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientRegistrationService;
import org.springframework.security.oauth2.provider.approval.TokenServicesUserApprovalHandler;

public class AAATokenServicesUserApprovalHandler extends
		TokenServicesUserApprovalHandler {

	private ClientRegistrationService clientRegistration;

	@Override
	public boolean isApproved(AuthorizationRequest authorizationRequest,
			Authentication userAuthentication) {
/*
		String flag = authorizationRequest.getApprovalParameters().get(
				AuthorizationRequest.USER_OAUTH_APPROVAL);
		boolean approved = flag != null && flag.toLowerCase().equals("true");
		if (approved) {
			Set<String> scope = new HashSet<String>();
			scope.add("read");

			Set<String> authorizedGrantTypes = new HashSet<String>();
			scope.add("authorization_code");
			scope.add("implicit");
			scope.add("refresh_token");

			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new AAARoleClient());

			AAAClientDetails clientDetails = new AAAClientDetails("test",
					scope, authorizedGrantTypes, authorities);

			clientRegistration.addClientDetails(clientDetails);
		}
*/		
		
		return super.isApproved(authorizationRequest, userAuthentication);

	}

	public ClientRegistrationService getClientRegistration() {
		return clientRegistration;
	}

	public void setClientRegistration(
			ClientRegistrationService clientRegistration) {
		this.clientRegistration = clientRegistration;
	}

}
