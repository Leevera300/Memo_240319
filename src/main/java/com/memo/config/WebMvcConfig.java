package com.memo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.memo.common.FileManagerService;
import com.memo.interceptor.PermissionIncterceptor;

@Configuration // 설정을 위한 Spring Bean
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Autowired
	private PermissionIncterceptor interceptor;
	
	// 인터셉터 설정
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry
		.addInterceptor(interceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/error", "/css/**", "/img/**", "/user/sign-out");
	}
	
	// 이미지 path와  서버의 업로드 된 실제 이미지와 매핑 설정
	@Override
	public void addResourceHandlers(
			ResourceHandlerRegistry registry) {
		
		registry
		.addResourceHandler("/images/**") // web path	http://localhost/images/aaaa_1721209535801/sparrow-8848051_960_720.jpg
		.addResourceLocations("file:///" + FileManagerService.FILE_UPLOAD_PATH); // 실제 이미지 파일 위치 D:\Michael (마이클)\6_spring_project\memo\memo_workspace\images\aaaa_1721209535801
	}
}
