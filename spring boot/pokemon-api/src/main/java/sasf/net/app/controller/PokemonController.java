package sasf.net.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import sasf.net.app.entity.Pokemon;
import sasf.net.app.service.PokemonService;

@CrossOrigin(value = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

	@Autowired
	private PokemonService pokemonService;

	@GetMapping
	@ResponseBody
	public ResponseEntity<?> readAllPokemon() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(pokemonService.findAllPokemon());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pokemon pokemon) {
		try {
			Pokemon res = pokemonService.savePokemon(pokemon);
			if (res == null) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(res);
			}
			return ResponseEntity.status(HttpStatus.CREATED).body(res);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			Optional<Pokemon> oPokemon = pokemonService.findByIdPokemon(id);
			if (!oPokemon.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			pokemonService.deleteByIdPokemon(oPokemon);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
		}
	}

}
