package com.yedam.app.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.yedam.app.security.mapper.UserMapper;
import com.yedam.app.security.service.LoginUserVO;
import com.yedam.app.security.service.UserVO;

//시큐리티가 알려면 빈을 등록해야함
@Service
public class CustomerUserDetailsService implements UserDetailsService {
	@Autowired  //DB에서 가져옴
	UserMapper userMapper;
	
	@Override //pw는 넘겨받지 않고, id만 넘겨받음 => 있는지 없는지만 체크.
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = userMapper.getUserInfo(username);
		
		if(userVO == null) { //정보가 없습니다~를 에러로 전달. 왜? 에러발생? => 
							 //흐름을 멈출건지(지금은 여기에 해당), 체크만 하고 진행할건지. 
			throw new UsernameNotFoundException(username);
		}
		
		return new LoginUserVO(userVO);
	}

}
