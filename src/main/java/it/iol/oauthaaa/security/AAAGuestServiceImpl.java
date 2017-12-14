package it.iol.oauthaaa.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.BaseClientDetails;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.stereotype.Service;

@Service
public class AAAGuestServiceImpl implements ClientDetailsService {

	private String id;
	private String secretKey;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public ClientDetails loadClientByClientId(String clientId)
			throws OAuth2Exception {
		if (clientId.equals(id)) {
			List<String> authorizedGrantTypes = new ArrayList<String>();
			authorizedGrantTypes.add("password");
			authorizedGrantTypes.add("refresh_token");
			authorizedGrantTypes.add("client_credentials");
			authorizedGrantTypes.add("implicit");

			BaseClientDetails clientDetails = new BaseClientDetails();
			clientDetails.setClientId(id);
			clientDetails.setClientSecret(secretKey);
			clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);

			return clientDetails;
		} else {
			throw new NoSuchClientException("No client recognized with id: "
					+ clientId);
		}
	}

}
