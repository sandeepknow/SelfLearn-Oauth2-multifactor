package com.bootcamp.oauth.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Entity
public class Role {
	
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="role_name")
	private String roleName;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="role_permission", joinColumns = {
			@JoinColumn(name = "role_id", referencedColumnName = "id")}, inverseJoinColumns = {
			@JoinColumn(name = "permission_id", referencedColumnName = "id")})
	private List<Permission> permissions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	
}
