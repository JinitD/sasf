package sasf.com.correct.controller;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sasf.com.correct.entity.User;
import sasf.com.correct.service.UserService;


@Controller
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService  userService;
	
	//create a new user
	@PostMapping
	@Transactional
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
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody User usuarioPut) {
		Optional<User> oUsuario = userService.findById(id);
		if (!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oUsuario = Optional.ofNullable(usuarioPut);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.save(oUsuario.get()));

	}
	
	//read all user
	@GetMapping
	public ResponseEntity<?> readAll(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		
	}}
	
}
