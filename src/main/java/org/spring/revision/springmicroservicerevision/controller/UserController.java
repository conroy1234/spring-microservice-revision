package org.spring.revision.springmicroservicerevision.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.spring.revision.springmicroservicerevision.bean.User;
import org.spring.revision.springmicroservicerevision.exception.UserNotFoundException;
import org.spring.revision.springmicroservicerevision.repository.UserSReporisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	MessageSource messageSource;
	
	@Autowired
	UserSReporisitory userrepor;
	
	@GetMapping("/find/user")
	public List<User> findAll(){		
		return userrepor.findAll();
	}
	
	@PostMapping("/find/user")
	public ResponseEntity<String> postUser(@Valid @RequestBody User user) {
		userrepor.saveUser(user);	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(user.getId()).toUri();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+location);
		return new ResponseEntity<String>(location+"/"+user.getId(),HttpStatus.CREATED);
	}
	
	@GetMapping("/find/user/{id}")
	public List<User> findById(@PathVariable Integer id) {
		List<User> users =userrepor.findById2(id);
		
		if(users.isEmpty()) {
			throw new UserNotFoundException("cannot found user with id :"+id);
		}		
	
		return users;		
	}
	
	@DeleteMapping("/find/user/{id}")
	public ResponseEntity<User> removeUser(@PathVariable int id) {
		User user =userrepor.removeUser(id);
		return new ResponseEntity(user,HttpStatus.OK);
	}
	
	@GetMapping("/find/user-links/{id}")
	public Resource<User> linkToUsers(@PathVariable int id) {
		User user = userrepor.findById(id);
		ControllerLinkBuilder links =ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).findAll());
	
		Resource<User> resource = new Resource<User>(user, links.withRel("find-all"));
		resource.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).removeUser(id)).withRel("remove-user"));
		return resource ;
	}
	

}
