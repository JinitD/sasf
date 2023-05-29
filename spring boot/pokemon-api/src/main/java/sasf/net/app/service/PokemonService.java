package sasf.net.app.service;

import java.util.Optional;

import sasf.net.app.entity.Pokemon;

public interface PokemonService {

	public Iterable<Pokemon> findAllPokemon();

	public Optional<Pokemon> findByIdPokemon(Long id);

	public Pokemon savePokemon(Pokemon pokemon);

	public void deleteByIdPokemon(Optional<Pokemon> pokemon);
}
