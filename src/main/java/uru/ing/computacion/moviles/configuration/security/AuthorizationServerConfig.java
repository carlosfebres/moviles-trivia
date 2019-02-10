package uru.ing.computacion.moviles.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	public static final String CLIENT_NAME = "client";
	public static final String CLIENT_PASSWORD = "password";


	private final AuthenticationManager authenticationManager;
	private final TokenStore tokenStore;

	@Autowired
	public AuthorizationServerConfig(AuthenticationManager authenticationManager, TokenStore tokenStore) {
		this.authenticationManager = authenticationManager;
		this.tokenStore = tokenStore;
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints
				.authenticationManager(authenticationManager)
				.tokenStore(tokenStore);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		oauthServer
				.tokenKeyAccess("permitAll()")
				.checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients();
	}

	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients
				.inMemory()
				.withClient(CLIENT_NAME)
				.secret("{noop}" + CLIENT_PASSWORD)
				.authorizedGrantTypes("password", "refresh_token")
				.scopes("all");
	}


}