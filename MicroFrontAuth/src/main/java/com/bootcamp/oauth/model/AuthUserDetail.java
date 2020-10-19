package com.bootcamp.oauth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetail extends UserEntity implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7569388966329361424L;
	
	public AuthUserDetail(UserEntity user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		
		List<GrantedAuthority> granteAuthorities = new ArrayList<>();
		
		getRoles().forEach(role -> {
			granteAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
			role.getPermissions().forEach(permission ->{
				granteAuthorities.add(new SimpleGrantedAuthority(permission.getPermissionName()));
			});
		});
		return granteAuthorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return super.getEmailId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
