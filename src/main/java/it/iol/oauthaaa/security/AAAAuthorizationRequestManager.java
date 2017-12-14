package it.iol.oauthaaa.security;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.DefaultAuthorizationRequest;
import org.springframework.security.oauth2.provider.DefaultAuthorizationRequestManager;

public class AAAAuthorizationRequestManager extends DefaultAuthorizationRequestManager {

	private final ClientDetailsService clientDetailsService;

	public AAAAuthorizationRequestManager(
			ClientDetailsService clientDetailsService) {
		super(clientDetailsService);
		
		this.clientDetailsService = clientDetailsService;
		// TODO Auto-generated constructor stub
	}

	@Override
	public AuthorizationRequest createAuthorizationRequest(Map<String, String> parameters) {

		String clientId = parameters.get("client_id");
		if (clientId == null) {
			throw new InvalidClientException("A client id must be provided");
		}
		ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
		Set<String> scopes = OAuth2Utils.parseParameterList(parameters.get("scope"));
		if ((scopes == null || scopes.isEmpty())) {
			// If no scopes are specified in the incoming data, use the default values registered with the client
			// (the spec allows us to choose between this option and rejecting the request completely, so we'll take the
			// least obnoxious choice as a default).
			scopes = clientDetails.getScope();
		}
		DefaultAuthorizationRequest request = new DefaultAuthorizationRequest(parameters, Collections.<String, String> emptyMap(),
				clientId, scopes);
		
//		request.setApproved(true);
		
		request.addClientDetails(clientDetails);
		return request;

	}
}
