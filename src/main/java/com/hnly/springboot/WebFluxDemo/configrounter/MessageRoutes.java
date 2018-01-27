
package com.hnly.springboot.WebFluxDemo.configrounter;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import com.hnly.springboot.WebFluxDemo.handler.UserHandler;

@Configuration
public class MessageRoutes 
{
	
	private UserHandler userHandler;

	public MessageRoutes(UserHandler userHandler) 
	{
		this.userHandler = userHandler;
	}
	
	@Bean
	public RouterFunction<?> routerFunction() 
	{
		return	route(GET("/api/user").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleGetUsers)
				.and(route(GET("/api/user/{id}").and(accept(MediaType.APPLICATION_JSON)), userHandler::handleGetUserById));
            //  .and(route(POST("/users"), userHandler::handleGetUsers));
		
	}

}

