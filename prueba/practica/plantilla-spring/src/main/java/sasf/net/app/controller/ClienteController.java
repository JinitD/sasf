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

import sasf.net.app.entity.Cliente;
import sasf.net.app.service.ClienteService;

@CrossOrigin
@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;

	
	// read all
	@GetMapping
	public ResponseEntity<?> readAll() {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.findAll());// aqui
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Boolean res = clienteService.deleteById(id);// aqui
		if (!res) {
			return ResponseEntity.notFound().build();// aqui
		}
		return ResponseEntity.ok().build();
	}

	// create a new
	@PostMapping
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Cliente cliente) {
		Optional<Cliente> oCliente = clienteService.findById(id);
		if (!oCliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oCliente = Optional.ofNullable(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(oCliente.get()));

	}
}
