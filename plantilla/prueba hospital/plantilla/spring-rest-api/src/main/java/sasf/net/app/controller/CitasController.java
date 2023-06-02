package sasf.net.app.controller;

import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.Citas;
import sasf.net.app.service.CitasService;

@RestController
@RequestMapping("/api/privade/citas")
public class CitasController {
	
	@Autowired
	private CitasService entityService;
	
	@GetMapping
	@ResponseBody
	public  ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(entityService.findAllEntity());
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> putUser(@PathVariable Long id, @RequestBody Citas entityPut) {
		Optional<Citas> oEntitiy = entityService.findOneEntityById(id);
		if (!oEntitiy.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oEntitiy = Optional.ofNullable(entityPut);
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
		Optional<Citas> oEntitiy = entityService.findOneEntityById(id);
		if (!oEntitiy.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(oEntitiy.get());
	}
}
