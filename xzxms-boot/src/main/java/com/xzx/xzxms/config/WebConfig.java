package com.xzx.xzxms.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	/**
	 * 将自定义拦截器作为Bean写入配置
	 * @return
	 */
	@Bean
	public JwtInterceptor jwtInterceptor() {
		return new JwtInterceptor();
	}
	@Value("${webconfig.test}")
	private Boolean test;
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET","POST","PUT","OPTIONS","DELETE","PATCH")
				.allowedHeaders("*")
				.allowCredentials(true)
				.maxAge(3600);
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		if(test) {
			//拦截路径可自行配置多个 可用 ，分隔开
			registry.addInterceptor(jwtInterceptor())
					.addPathPatterns("/**")
					.excludePathPatterns(
							"/**/**");
		}else {
			//拦截路径可自行配置多个 可用 ，分隔开
			registry.addInterceptor(jwtInterceptor())
//				.addPathPatterns("/category/**","/article/**","/user/**","/role/**","/privilege/**")
					.addPathPatterns("/**")
					.excludePathPatterns(
							"/swagger-resources/**","/v2/**","/swagger-ui.html","/webjars/**",
							"/user/login","/user/logout","user/findMenuByUserIdUsingGET","/user/getCode",
							"/user/register","/file/upload","/file/uploadCache","/webSocket/*");
		}
	}

}
