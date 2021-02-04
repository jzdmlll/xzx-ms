package com.xzx.xzxms.config;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
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
@Configuration
@EnableSwagger2
public class Swagger {

	// 定义分隔符,配置Swagger多包
	private static final String splitor = ";";

	@Bean
	public Docket swaggerSpringMvcPlugin() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(basePackage(
						"com.xzx.xzxms.system.controller"+splitor+
						"com.xzx.xzxms.inquiry.controller"+splitor+
						"com.xzx.xzxms.chapter.controller"+splitor+
						"com.xzx.xzxms.equipment.controller"+splitor+
						"com.xzx.xzxms.purchase.controller"))
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

	public static Predicate<RequestHandler> basePackage(final String basePackage) {
		return input -> declaringClass(input).transform(handlerPackage(basePackage)).or(true);
	}
	private static Function<Class<?>, Boolean> handlerPackage(final String basePackage)     {
		return input -> {
			// 循环判断匹配
			for (String strPackage : basePackage.split(splitor)) {
				boolean isMatch = input.getPackage().getName().startsWith(strPackage);
				if (isMatch) {
					//System.out.println(input.getPackage().getName());
					return true;
				}
			}
			return false;
		};
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

	private static Optional<? extends Class<?>> declaringClass(RequestHandler input) {
		return Optional.fromNullable(input.declaringClass());
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
				.description("新自信管理平台").termsOfServiceUrl("http://218.87.96.53:8006/")
				// 版本号
				.version("3.0.0").build();
	}
}

