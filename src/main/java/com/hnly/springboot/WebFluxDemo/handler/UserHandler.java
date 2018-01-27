package com.hnly.springboot.WebFluxDemo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;


import com.hnly.springboot.WebFluxDemo.model.User;
import com.hnly.springboot.WebFluxDemo.repository.UserRepository;

import reactor.core.publisher.Mono;

@Service
public class UserHandler
{

	@Autowired
	private UserRepository userRepository;

	public Mono<ServerResponse> handleGetUsers(ServerRequest request) 
	{
		return ServerResponse.ok().body(userRepository.getUsers(), User.class);
	}

	public Mono<ServerResponse> handleGetUserById(ServerRequest request)
	{
		return userRepository.getUserById(request.pathVariable("id"))
				.flatMap(user -> ServerResponse.ok().body(Mono.just(user), User.class))
				.switchIfEmpty(ServerResponse.notFound().build());
	}

}
