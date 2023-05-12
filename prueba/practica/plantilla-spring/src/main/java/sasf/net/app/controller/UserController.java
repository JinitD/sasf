package sasf.net.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.User;
import sasf.net.app.service.UserService;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	// read all
	@GetMapping
	public ResponseEntity<?> readAll() {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(userService.findAllUser());// aqui
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		// Boolean res = pokemonService.deleteByIdPokemon(id);// aqui
		Boolean res = true;
		if (!res) {
			return ResponseEntity.notFound().build();// aqui
		}
		return ResponseEntity.ok().build();
	}

	// create a new
	@PostMapping
	public ResponseEntity<?> create(@RequestBody User user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(null);// aqui
	}
}
