package com.xzx.xzxms.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:Swagger2 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2020年2月03日 下午6:22:51 <br/>
 * @author   Lzc
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
/*@Configuration
@EnableSwagger2
public class Swagger {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.xzx.xzxms.web.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private List<ApiKey> SecurityScheme() {
		ArrayList<ApiKey> apiKeyList = new ArrayList();
		apiKeyList.add(new ApiKey("X-Token", "X-Token", "header"));
		return  apiKeyList;
	}
	private List<SecurityContext> securityContexts() {
		List<SecurityContext> securityContexts=new ArrayList<>();
		securityContexts.add(
				SecurityContext.builder()
						.securityReferences(defaultAuth())
						.forPaths(PathSelectors.regex("^(?!auth).*$"))
						.build());
		return securityContexts;
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		List<SecurityReference> securityReferences=new ArrayList<>();
		securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
		return securityReferences;
	}


	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("失物招领管理平台开发者接口调试")
				.description("失物招领管理平台，http://lostfound.smalllei.cn/")
				.termsOfServiceUrl("http://www.smalllei.cn/lostfound")
				.version("1.0")
				.build();
	}
}*/
@Configuration
@EnableSwagger2
public class Swagger {
	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.xzx.xzxms.web.controller"))
				.paths(PathSelectors.any())
				.build()
				.securitySchemes(securitySchemes())
				.securityContexts(securityContexts());
	}
	private List<ApiKey> securitySchemes() {
		List<ApiKey> apiKeyList= new ArrayList<ApiKey>();
		apiKeyList.add(new ApiKey("X-Token", "X-Token", "header"));
		return apiKeyList;
	}

	private List<SecurityContext> securityContexts() {
		List<SecurityContext> securityContexts=new ArrayList<>();
		securityContexts.add(
				SecurityContext.builder()
						.securityReferences(defaultAuth())
						.forPaths(PathSelectors.regex("^(?!auth).*$"))
						.build());
		return securityContexts;
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		List<SecurityReference> securityReferences=new ArrayList<>();
		securityReferences.add(new SecurityReference("X-Token", authorizationScopes));
		return securityReferences;
	}

	// 构建 api文档的详细信息函数,注意这里的注解引用的是哪个
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题1
				.title("新自信管理平台 API接口")
				// 描述
				.description("新自信管理平台").termsOfServiceUrl("http://localhost:9527/")
				// 版本号
				.version("1.0.1").build();
	}
}

