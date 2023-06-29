package sasf.net.app.payload;

import java.util.List;

public class JwtResponse {
	  private String token;
	  private String type = "Bearer";
	  private Long id;
	  private String username;
	  private String email;
	  private String name;
	  private String lastname;
	  private String status;
	  private List<String> roles;

	  public JwtResponse(String accessToken, Long id, String username, String email, String name, String lastname, String status, List<String> roles) {
	    this.token = accessToken;
	    this.id = id;
	    this.username = username;
	    this.email = email;
	    this.name = name;
	    this.lastname = lastname;
	    this.status = status;
	    this.roles = roles;
	  }
	  

	  public final String getName() {
		return name;
	}


	public final void setName(String name) {
		this.name = name;
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


	public final void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getLastname() {
	    return lastname;
	  }

	  public void setLastname(String lastname) {
	    this.lastname = lastname;
	  }

	  public String getStatus() {
	    return status;
	  }

	  public void setStatus(String status) {
	    this.status = status;
	  }

	  public List<String> getRoles() {
	    return roles;
	  }
}
