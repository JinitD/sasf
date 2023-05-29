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

import sasf.net.app.entity.Usuario;
import sasf.net.app.service.UsuarioService;

@Controller
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	@ResponseBody
	public  ResponseEntity<?>  findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.findAll());
	}

	// create a new user
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Usuario usuarioPut) {
		Optional<Usuario> oUsuario = usuarioService.findById(id);
		if (!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oUsuario = Optional.ofNullable(usuarioPut);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioService.save(oUsuario.get()));

	}

}
