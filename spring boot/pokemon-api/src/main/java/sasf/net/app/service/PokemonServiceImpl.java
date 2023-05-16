package sasf.net.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Pokemon;
import sasf.net.app.repository.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService{
	
	@Autowired
	private PokemonRepository pokemonRepository;

	@Override
	public Iterable<Pokemon> findAllPokemon() {
		return pokemonRepository.findByStatus();
	}

	@Override
	public Optional<Pokemon> findByIdPokemon(Long id) {
		// TODO Auto-generated method stub
		return pokemonRepository.findById(id);
	}

	@Override
	public Pokemon savePokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		return pokemonRepository.save(pokemon);
	}

	@Override
	public void deleteByIdPokemon(Optional<Pokemon> pokemon) {
		pokemon.get().setStatus('n');
		pokemonRepository.save(pokemon.get());
		
	}

	
	
}
