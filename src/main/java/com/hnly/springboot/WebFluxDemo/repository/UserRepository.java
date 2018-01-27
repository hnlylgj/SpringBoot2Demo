package com.hnly.springboot.WebFluxDemo.repository;

import java.util.Arrays;
import java.util.List;



import org.springframework.stereotype.Repository;
import com.hnly.springboot.WebFluxDemo.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository 
{
	private  final List<User> users = Arrays.asList(new User(1L, "User1"), new User(2L, "User2"));

	//private  List<User> users;
	
	public  UserRepository() 
	{
		 //users=new List<User>(new User(1L, "User1"), new User(2L, "User2"));
		 //users = Arrays.asList(new User(1L, "User1"), new User(2L, "User2"));
		
		  /*
		 users.add(new User(1L, "User1"));
		 users.add(new User(2L, "User2"));
		 users.add(new User(3L, "User3"));
		 users.add(new User(4L, "User4"));
		 users.add(new User(5L, "User5"));
		 users.add(new User(6L, "User6"));
		 users.add(new User(7L, "User7"));
		 users.add(new User(8L, "User8"));
		 users.add(new User(9L, "User18"));
		 users.add(new User(10L, "User9"));
		 users.add(new User(11L, "User10"));
		 users.add(new User(12L, "User11"));
		 users.add(new User(13L, "User12"));
		 users.add(new User(14L, "User13"));
		 users.add(new User(15L, "User14"));
		 users.add(new User(16L, "User15"));
		 users.add(new User(17L, "User16"));
		 users.add(new User(18L, "User17"));
		 */
		 
	}

	
	public Mono<User> getUserById(String id) 
	{
		
	  return Mono.justOrEmpty(users.stream().filter(user -> {return user.getId().equals(Long.valueOf(id));}).findFirst().orElse(null));
	
	}

	public Flux<User> getUsers() 
	{
		return Flux.fromIterable(users);
	}

}
