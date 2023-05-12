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

import sasf.net.app.entity.Asesor;
import sasf.net.app.service.AsesorService;
@CrossOrigin
@RestController
@RequestMapping("/api/asesor")
public class AsesorController {
	@Autowired
	private AsesorService asesorService;

	
	// read all
	@GetMapping
	public ResponseEntity<?> readAll() {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(asesorService.findAll());// aqui
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Boolean res = asesorService.deleteById(id);// aqui
		if (!res) {
			return ResponseEntity.notFound().build();// aqui
		}
		return ResponseEntity.ok().build();
	}

	// create a new
	@PostMapping
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Asesor asesor) {
		Optional<Asesor> oAsesor = asesorService.findById(id);
		if (!oAsesor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oAsesor = Optional.ofNullable(asesor);
		return ResponseEntity.status(HttpStatus.CREATED).body(asesorService.save(oAsesor.get()));

	}
}
