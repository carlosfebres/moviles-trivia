package uru.ing.computacion.moviles.entity.SpringOauth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_access_token", schema = "public")
public class oauthAccessToken {

	@Column(name = "token_id")
	private String tokenId;

	@Column(name = "token")
	private byte[] token;

	@Id
	@Column(name = "authentication_id")
	private String authenticationId;

	@Column(name = "user_name")
	private String username;

	@Column(name = "client_id")
	private String clientId;

	@Column(name = "authentication")
	private byte[] authentication;

	@Column(name = "refresh_token")
	private String refreshToken;

	public oauthAccessToken() {
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public byte[] getToken() {
		return token;
	}

	public void setToken(byte[] token) {
		this.token = token;
	}

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public byte[] getAuthentication() {
		return authentication;
	}

	public void setAuthentication(byte[] authentication) {
		this.authentication = authentication;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
}
