package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Pokemon;

public interface PokemonService {
	public List<Pokemon> findAllPokemon();

	public Pokemon savePokemon(Pokemon pokemon);

	public Boolean deleteByIdPokemon(Long id);
	
	public Optional<Pokemon> findById(Long id);

}
