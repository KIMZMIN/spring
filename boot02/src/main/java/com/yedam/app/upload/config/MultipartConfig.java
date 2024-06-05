package com.yedam.app.upload.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;


//스프링부트 3.0 버전 부터
@Configuration
public class MultipartConfig {

	@Bean	//동작을 담당하는 Bean
	MultipartResolver multipartResolver() {
		return new StandardServletMultipartResolver();
	}
	
	@Bean	//설정을 담당하는 Bean  등록하겠습니다?
	MultipartConfigElement multipartConfigElement() {
		MultipartConfigFactory factory = new MultipartConfigFactory();
		
		factory.setLocation("C:/Temp");			//저장위치
		factory.setFileSizeThreshold(DataSize.ofMegabytes(0));	//메모리에 몇바이트까지 올릴건지
		factory.setMaxFileSize(DataSize.ofMegabytes(10));       //파일 최대 사이즈
		factory.setMaxRequestSize(DataSize.ofMegabytes(100));   //파일무시하고 Request사이즈
		//DataSize.ofMegabytes(0): 메가바이트 ;;  1KB : 1000B /  1MB : 1KB * 1024byte = 1024KB
		return factory.createMultipartConfig();
	}
}
