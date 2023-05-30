package sasf.net.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Users implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;


	@Column(name = "name", length = 155, nullable = false)
	private String name;

	@NotBlank
	@Column(name = "lastname", length = 155, nullable = false)
	private String lastname;

	@Column(name = "username", length = 16, unique = true, nullable = false)
	private String username;

	@NotBlank
	@Size(max = 255)
	@Email
	@Column(name = "email", length = 255, unique = true, nullable = false)
	private String email;

	@NotBlank
	@NotNull
	@Column(name = "password", length = 255, nullable = false)
	private String password;
	
	@NotBlank
	@Size(max = 115)
	@Column(name = "token_exp", columnDefinition = "bigint default 0")
	private Long tokenExp;

	@Size(max = 1)
	@Column(name = "status", length = 1)
	private String status;

	@Column(name = "darkmode")
	private Boolean darkmode;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	public  Long getId() {
		return id;
	}

	public  void setId(Long id) {
		this.id = id;
	}

	public  String getName() {
		return name;
	}

	public  void setName(String name) {
		this.name = name;
	}

	public  String getLastname() {
		return lastname;
	}

	public  void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public  String getUsername() {
		return username;
	}

	public  void setUsername(String username) {
		this.username = username;
	}

	public  String getEmail() {
		return email;
	}

	public  void setEmail(String email) {
		this.email = email;
	}

	public  String getPassword() {
		return password;
	}

	public  void setPassword(String password) {
		this.password = password;
	}

	public  Long getTokenExp() {
		return tokenExp;
	}

	public  void setTokenExp(Long tokenExp) {
		this.tokenExp = tokenExp;
	}

	

	public  Boolean getDarkmode() {
		return darkmode;
	}

	public  void setDarkmode(Boolean darkmode) {
		this.darkmode = darkmode;
	}

	public  LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public  void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public  LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public  void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public  String getStatus() {
		return status;
	}

	public  void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
