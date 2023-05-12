package sasf.net.app.controller;

import java.util.Optional;

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

import sasf.net.app.entity.Inmueble;
import sasf.net.app.service.InmuebleService;

@CrossOrigin
@RestController
@RequestMapping("/api/inmueble")

public class InmuebleController {
	@Autowired
	private InmuebleService inmuebleService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		Optional<Inmueble> oInmueble = inmuebleService.findById(id);
		if (!oInmueble.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oInmueble);

	}
	
	// read all
	@GetMapping
	public ResponseEntity<?> readAll() {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(inmuebleService.findAllByStatus());// aqui
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Boolean res = inmuebleService.deleteById(id);// aqui
		if (!res) {
			return ResponseEntity.notFound().build();// aqui
		}
		return ResponseEntity.ok().build();
	}

	// create a new
	@PostMapping
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Inmueble inmueble) {
		Optional<Inmueble> oInmue = inmuebleService.findById(id);
		if (!oInmue.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oInmue = Optional.ofNullable(inmueble);
		return ResponseEntity.status(HttpStatus.CREATED).body(inmuebleService.save(oInmue.get()));

	}
}
