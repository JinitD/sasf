package sasf.net.app.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.User;
import sasf.net.app.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService  userService;
	
	//create a new user
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	//read an user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id){
		Optional<User> oUser  = userService.findById(id);
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oUser);
		
	}
	//update an user
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userDetails ,@PathVariable Long id){
		Optional<User> oUser  = userService.findById(id);
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.copyProperties( userDetails, oUser.get());
		oUser.get().setName(userDetails.getName());
		oUser.get().setUsername(userDetails.getUsername());
		oUser.get().setEmail(userDetails.getEmail());
		oUser.get().setEnable(userDetails.getEnable());
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(oUser.get()));
	}
	//delete an user
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		Optional<User> oUser  = userService.findById(id);
		if(!oUser.isPresent()) { 
			return ResponseEntity.notFound().build();
		}
		userService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	//read all user
	@GetMapping
	public List<User> readAll(){
		List<User> users = StreamSupport
				.stream(userService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return users;
	}
	
}
