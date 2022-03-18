package isi.com.Qatar2022.Payload.Response;

import java.util.List;

import isi.com.Qatar2022.Entities.Billet;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private Long num_carte;
	private Long code_secret;
	private List<String> roles;
	private List<Billet> billets;

	

	public JwtResponse(String token, Long id, String username, String email, List<String> roles) {
		super();
		this.token = token;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}

	public JwtResponse(String token, String type, Long id, String username, String email, Long num_carte,
			Long code_secret, List<String> roles, List<Billet> billets) {
		super();
		this.token = token;
		this.type = type;
		this.id = id;
		this.username = username;
		this.email = email;
		this.num_carte = num_carte;
		this.code_secret = code_secret;
		this.roles = roles;
		this.billets = billets;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public Long getNum_carte() {
		return num_carte;
	}

	public void setNum_carte(Long num_carte) {
		this.num_carte = num_carte;
	}

	public Long getCode_secret() {
		return code_secret;
	}

	public void setCode_secret(Long code_secret) {
		this.code_secret = code_secret;
	}

	public List<Billet> getBillets() {
		return billets;
	}

	public void setBillets(List<Billet> billets) {
		this.billets = billets;
	}
	
}

