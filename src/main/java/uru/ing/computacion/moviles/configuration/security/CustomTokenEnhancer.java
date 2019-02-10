package uru.ing.computacion.moviles.configuration.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
class CustomTokenEnhancer implements TokenEnhancer {
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		final Authentication userAuthentication = authentication.getUserAuthentication();

		final DefaultOAuth2AccessToken defaultOAuth2AccessToken = (DefaultOAuth2AccessToken) accessToken;
		Set<String> existingScopes = new HashSet<>(defaultOAuth2AccessToken.getScope());

		defaultOAuth2AccessToken.setScope(existingScopes);
		return defaultOAuth2AccessToken;
	}
}