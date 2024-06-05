package com.yedam.app.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


// URL에  http://localhost:8080/images/m1.png 이라고 치면 불러와진다.
// m1.png는 C드라이브 upload 폴더 안에 있음!!

@Configuration //@Component 안씀
public class WebMvcConfig implements WebMvcConfigurer{ //추상메소드가 아니다.. 내부에 추상메소드가 존재하지 않는다...
	@Value("${file.upload.path}")
	private String uploadPath;

	//리소스 핸들링
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**")    		  		 // URL       ] images밑에 파일이 매핑되어야함. 
				.addResourceLocations("file:///" + uploadPath, "");  // 실제 경로   ] 이 두개를 매핑해주는 역할을 한다? ;  
												//upload/ < 하위파일이기 때문에 슬러시 있어야함. 
	} 
	
	
	
	
	
}
