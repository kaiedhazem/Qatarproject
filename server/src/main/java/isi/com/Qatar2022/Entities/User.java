package isi.com.Qatar2022.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

	@Entity
	@Table(uniqueConstraints = { 
				@UniqueConstraint(columnNames = "username"),
				@UniqueConstraint(columnNames = "email") 
			})
	public class User implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		@NotBlank
		@Size(max = 20)
		private String username;
		@NotBlank
		@Size(max = 50)
		@Email
		private String email;
		@NotBlank
		@Size(max = 120)
		private String password;
		private Long num_carte;
		private Long code_secret;
		@OneToMany(mappedBy = "spectateur")
		private List<Billet> billets;
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(	name = "user_roles", 
					joinColumns = @JoinColumn(name = "user_id"), 
					inverseJoinColumns = @JoinColumn(name = "role_id"))
		private Set<Role> roles = new HashSet<>();
		
		
		public User() {
		}
		
		
		public User(String username, String email, String password , Long num_carte,
				Long code_secret, List<Billet> billets) {
			this.username = username;
			this.email = email;
			this.password = password;
			this.num_carte = num_carte;
			this.code_secret = code_secret;
			this.billets = billets;
		}
		

		public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
				@NotBlank @Size(max = 120) String password) {
			super();
			this.username = username;
			this.email = email;
			this.password = password;
		}


		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Set<Role> getRoles() {
			return roles;
		}
		public void setRoles(Set<Role> roles) {
			this.roles = roles;
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

