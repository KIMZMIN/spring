package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(); //해시함수? 단방향 
	}
	
	//메모리상  인증정보 등록 => 테스트 전용방식
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsService() {
		UserDetails user = User.builder()
							 .username("user1")
							 .password(passwordEncoder().encode("1234"))
							 .roles("USER") //ROLE_USER
							 //.authorities("ROLE_USER")
							 .build();
		
		UserDetails admin = User.builder()
				 .username("admin1")
				 .password(passwordEncoder().encode("1234"))
				 //.roles("ADMIN") //ROLE_ADMIN
				 .authorities("ROLE_ADMIN") 
				 .build();
		
		return new InMemoryUserDetailsManager(user, admin);		
	}
	
	//인증 및 인가 설정
	@Bean 
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			//위에서부터 하나씩 체크함.   
		http.authorizeHttpRequests()				 //경로별 권한
			.antMatchers("/", "/all").permitAll()    //메인페이지이기때문에 모든사람들을 받음.
			.antMatchers("/user/**").hasAnyRole("USER", "ADMIN") //ROLE_USER 
				//유저로 시작하는 모든 하위 경로 전부 권한체크. => USER 라는 권한체크
			.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN") // 어드민으로 시작하는 경우 ROLE_ADMIN 권한체크.
			.anyRequest().authenticated() //위에 전부 제외하고 일괄처리  
						// authenticated 인증된 사람들만 , 나머지 경로에 대해 처리
		.and()
		.formLogin()
			.defaultSuccessUrl("/url")
		.and()
		.logout()
			.logoutSuccessUrl("/url");
		return http.build();
	}
	
	
	
	
	
	
	
}
