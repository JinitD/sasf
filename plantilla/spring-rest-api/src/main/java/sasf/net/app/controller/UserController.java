package sasf.net.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.Users;
import sasf.net.app.service.UserService;


@Controller
@RestController
@RequestMapping("/api/privade/users")
@PreAuthorize("hasRole('ADMIN') or hasRole('USER')") 
public class UserController {
	@Autowired
	private UserService entityService;
	
	@GetMapping
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public  ResponseEntity<?>  findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(entityService.findAllEntity());
	}
	
	@GetMapping("/profile")
	@ResponseBody
	public  ResponseEntity<?> findOneUserByEmail(@RequestBody String email) {
		Optional<Users> oEntitiy = entityService.findOneEntityByEmail(email);
		if (!oEntitiy.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(oEntitiy.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody Users usuarioPut) {
		Optional<Users> oEntitiy = entityService.findOneEntityById(id);
		if (!oEntitiy.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oEntitiy = Optional.ofNullable(usuarioPut);
		return ResponseEntity.status(HttpStatus.OK).body(entityService.saveEntity(oEntitiy.get()));

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		boolean res = entityService.deleteEntity(id);
		if (!res) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado Correctamente");

	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable Long id ){
		Optional<Users> oEntitiy = entityService.findOneEntityById(id);
		if (!oEntitiy.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(oEntitiy.get());
	}
}
