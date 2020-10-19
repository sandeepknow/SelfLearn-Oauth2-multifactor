package com.bootcamp.oauth.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
@Table(name="users")
public class UserEntity implements Serializable{

	@Id
	@GeneratedValue
	private String id;

	@Column(name = "email_id")
	private String emailId;
	private String password;
//	private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String mobile;
	private String country;
	private String user_type;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="role_user", joinColumns = {
			@JoinColumn(name = "user_id", referencedColumnName = "id")}, inverseJoinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private List<Role> roles;

	public UserEntity(UserEntity user) {
		this.emailId = user.emailId;
		this.password = user.password;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.mobile = user.mobile;
		this.country = user.country;
		this.user_type = user.user_type;
		this.roles = user.roles;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
}
