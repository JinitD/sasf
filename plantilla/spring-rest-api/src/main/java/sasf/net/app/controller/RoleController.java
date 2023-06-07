package sasf.net.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.Role;
import sasf.net.app.service.RoleService;

@Controller
@RestController
@RequestMapping("/api/public/role")
public class RoleController {
	
	@Autowired
	private RoleService entintyService;
	
	@GetMapping
	@ResponseBody
	public  ResponseEntity<?>  findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(entintyService.findAllEntity());
	}

	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable Long id ){
		Optional<Role> oEntity = entintyService.findById(id);
		if (!oEntity.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(oEntity.get());
	}
	
}
