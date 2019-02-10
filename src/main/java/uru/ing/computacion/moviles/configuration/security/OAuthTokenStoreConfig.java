package uru.ing.computacion.moviles.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.sql.DataSource;

@Configuration
public class OAuthTokenStoreConfig {

	private final DataSource dataSource;

	@Autowired
	public OAuthTokenStoreConfig(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public TokenStore tokenStore() {
		return new CustomJdbcTokenStore(dataSource);
	}

}