package com.naresh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * In this configuration class, the  @EnableSwagger2  annotation enables Swagger support in the class.
 *  The  select()  method called on the Docket bean instance returns an  ApiSelectorBuilder 
 *  , which provides the  apis()  and  paths()  methods that are used to filter 
 *  the controllers and methods that are being documented using String predicates.*/

/*In the  Swagger2Config  class, we have added 
 * an  apiEndPointsInfo()  method that returns 
 * and ApiInfo object initialized with information about our API.*/


/*@Api	                   Marks a class as a Swagger resource.
@ApiModel	               Provides additional information about Swagger models.
@ApiModelProperty	       Adds and manipulates data of a model property.
@ApiOperation	           Describes an operation or typically an HTTP method against a specific path.
@ApiParam	               Adds additional meta-data for operation parameters.
@ApiResponse	           Describes a possible response of an operation.
@ApiResponses	           A wrapper to allow a list of multiple ApiResponse objects.*/



@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.naresh.controller"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiEndPointsInfo());
	}
	
	 private ApiInfo apiEndPointsInfo() {
	        return new ApiInfoBuilder().title("Spring Boot REST API")
	            .description("Employee Management REST API")
	            .contact(new Contact("Naresh", "www.naresh.com", "Nareshreddynagiri@gmail.com"))
	            .license("Apache 2.0")
	            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
	            .version("1.0.0")
	            .build();
	    }

}
