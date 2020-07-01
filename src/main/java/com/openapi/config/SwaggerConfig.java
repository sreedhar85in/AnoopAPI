package com.openapi.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springdoc.core.GroupedOpenApi;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.core.util.Constants;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Operation;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.tags.Tag;
/*import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.service.contexts.SecurityContext;*/

import org.springframework.web.method.HandlerMethod;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.servers.*;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.*;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.*;

/*import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
*/

@Configuration
@ComponentScan({"com.openapi.controller"})
//@OpenAPIDefinition(info = @Info(title = "My API for getting time with Springboot Rest and Open API spec", version = "v1"))
/*
 * @SecurityScheme( name = "basicAuth", type = SecuritySchemeType.HTTP, scheme =
 * "basic" )
 */

/*
 * @Server( url="<dev url>", description="DEV Server" )
 * 
 * @Server( url="<prod url>", description="PROD Server" )
 */


/*
 * @OpenAPIDefinition(
 * 
 * 
 * servers = {
 * 
 * @Server( url="<dev url>", description="DEV Server" ),
 * 
 * @Server( url="<prod url>", description="PROD Server" ) } )
 */

public class SwaggerConfig implements WebMvcConfigurer {
	
	/*@Bean
	public  Object userApi() {
		
		
	}
	*/
	/*
	 * @Bean public GroupedOpenApi groupOpenApi() { String paths[] = {"/api/**"};
	 * String packagesToscan[] = {"com.openapi.controller.OpenApiController"};
	 * String packagesToscan2[] = {"com.openapi.controller.SomnaOpenApiController"};
	 * return GroupedOpenApi.builder().setGroup("groups").pathsToMatch(paths).
	 * packagesToScan(packagesToscan)
	 * 
	 * .build(); }
	 */
	/*
	 * @Bean public GroupedOpenApi somnaApi(){ String[] paths = {"/api2/**"}; return
	 * GroupedOpenApi.builder() .setGroup("groups") .pathsToMatch(paths) .build(); }
	 */
	
	 private static final String API_KEY = "apiKey";
	 Contact contact1 = new Contact().name("sreedhar").email("sreedhar85in@gmail.com").url("https://www.tranxactor.com/");
	 License license1 = new License().name("Apache 1.0").url("");
	// Server server1 = new Server().url("tokyo").description("city name1");
	// Server server2 = new Server().url("tokyo2").description("prod");
	// List<Server> sever4 = (List<Server>) new Server().url("tokyo").description("city name1").url("tokyo2").description("prod");
	 
	 //contact1.setEmail(""));
	 //contact1.
	 

	    @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	                .components(new Components()
	                        .addSecuritySchemes(API_KEY,apiKeySecuritySchema())) // define the apiKey SecuritySchema
	                .info(new Info().title("Open API Swagger Specifications Page").description(
	                        "RESTful services documentation with OpenAPI 3.").contact(contact1).license(license1))
	                .security(Collections.singletonList(new SecurityRequirement().addList(API_KEY))); // then apply it. If you don't apply it will not be added to the header in cURL
	    }

	    public SecurityScheme apiKeySecuritySchema() {
	        return new SecurityScheme()
	                .name("Authorization") // authorisation-token
	                
	                .description("Description about the TOKEN")
	                .in(SecurityScheme.In.HEADER)
	                .type(SecurityScheme.Type.APIKEY);
	    }
	    
	    
	    public static final String UNSECURED = "security.open";

	    @Bean
	    public OperationCustomizer customize() {
	        return (Operation operation, HandlerMethod handlerMethod) -> {
	            List<String> tags = operation.getTags();
	            if (tags != null && tags.contains(UNSECURED)) {
	                operation.setSecurity(Collections.emptyList());
	                operation.setTags(tags.stream()
	                        .filter(t -> !t.equals(UNSECURED))
	                        .collect(Collectors.toList()));
	            }
	            return operation;
	        };
	    }

	   

	}
	

	