package com.yedam.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;

@Getter //로그인 한 결과를 가지고 있음. 로그인됐을때 유지?..
public class LoginUserVO implements UserDetails{
	
	private UserVO userVO;
	
	public LoginUserVO(UserVO userVO){
		this.userVO = userVO;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority(userVO.getRoleName()));
		return auths;
	}

	@Override
	public String getPassword() {
		return userVO.getPassword();
	}

	@Override
	public String getUsername() {
		return userVO.getLoginId();
	}

	@Override //계정 만료 여부
	public boolean isAccountNonExpired() { 
		return true;
	}

	@Override //계정 잠금 여부
	public boolean isAccountNonLocked() { 
		return true;
	}

	@Override  //계정 패스워드 만료 여부
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override //계정 사용여부
	public boolean isEnabled() { 
		return true;
	}
	
}
