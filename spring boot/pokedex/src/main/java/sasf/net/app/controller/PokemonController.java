package sasf.net.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sasf.net.app.entity.Pokemon;
import sasf.net.app.service.PokemonService;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;

	// read all pokemon
	@GetMapping
	public ResponseEntity<?> readAll() {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.findAllPokemon());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Boolean res = pokemonService.deleteByIdPokemon(id);
		if (!res) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().build();
	}

	// create a new pokemon
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pokemon pokemon) {

		return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.savePokemon(pokemon));
	}

	// read an user
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Long id) {
		Optional<Pokemon> oPOkemon = pokemonService.findById(id);
		if (!oPOkemon.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oPOkemon);

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Pokemon pokemonPut) {
		Optional<Pokemon> oPOkemon = pokemonService.findById(id);
		if (!oPOkemon.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		oPOkemon = Optional.ofNullable(pokemonPut);
		return ResponseEntity.status(HttpStatus.CREATED).body(pokemonService.savePokemon(oPOkemon.get()));

	}

}
