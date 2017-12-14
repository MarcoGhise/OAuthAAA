package it.iol.oauthaaa.security;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class AAAClientDetails implements ClientDetails{

	protected String clientId;
	protected Set<String> resourceIds;
	protected boolean secretRequired;
	protected String clientSecret;
	
	protected boolean scoped;
	
	public Set<String> scope;

	public Set<String> authorizedGrantTypes;

	public Set<String> registeredRedirectUri;

	public Collection<GrantedAuthority> authorities;

	public Integer accessTokenValiditySeconds;

	public Integer refreshTokenValiditySeconds;

	public Map<String, Object> additionalInformation;
	
	public AAAClientDetails(String clientId, Set<String> scope, Set<String> authorizedGrantTypes, Collection<GrantedAuthority> authorities)
	{
		this.clientId=clientId;
		this.scope=scope;
		this.authorizedGrantTypes=authorizedGrantTypes;
		this.authorities=authorities;
	}

	public String getClientId() {
		return clientId;
	}

	public Set<String> getResourceIds() {
		return resourceIds;
	}

	public boolean isSecretRequired() {
		return secretRequired;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public boolean isScoped() {		
		return scoped;
	}

	public Set<String> getScope() {
		return scope;
	}

	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public Set<String> getRegisteredRedirectUri() {
		return registeredRedirectUri;
	}

	public Collection<GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	public Map<String, Object> getAdditionalInformation() {
		return additionalInformation;
	}

}
