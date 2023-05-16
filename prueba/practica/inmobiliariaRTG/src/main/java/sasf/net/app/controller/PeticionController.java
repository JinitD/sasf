package sasf.net.app.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.Peticion;
import sasf.net.app.service.PeticionService;

@Controller
@RestController
@RequestMapping("/api/peticion")
public class PeticionController {

	@Autowired
	private PeticionService peticionService;

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable Long id) {
		Optional<Peticion> oPeticion = peticionService.findById(id);
		if (!oPeticion.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oPeticion);
	}

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> findAll() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(peticionService.findAll());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Peticion peticionPut) {
		Optional<Peticion> oPeticion = peticionService.findById(id);
		if (!oPeticion.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oPeticion = Optional.ofNullable(peticionPut);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(peticionService.save(oPeticion.get()));

	}


	@PostMapping()
	public ResponseEntity<?> save(@RequestBody Peticion peticion   ){
		return ResponseEntity.status(HttpStatus.CREATED).body(peticionService.save(peticion));
	}

}
