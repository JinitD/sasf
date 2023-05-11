package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Pokemon;
import sasf.net.app.repository.PokemonRepository;

@Service
public class PokemonServiceImpl implements PokemonService{
	@Autowired
	private PokemonRepository  pokemonRepository;

	@Override
	public List<Pokemon> findAllPokemon() {
		// TODO Auto-generated method stub
		return pokemonRepository.findAllForStatus();
	}

	@Override
	public Pokemon savePokemon(Pokemon pokemon) {
		return pokemonRepository.save(pokemon);
	}

	@Override
	public Boolean deleteByIdPokemon(Long id) {
		Optional<Pokemon> delPOkemon = pokemonRepository.findById(id);
		
		if(delPOkemon.get() == null) {
			return false;
		}
		delPOkemon.get().setStatus('N');
		pokemonRepository.save(delPOkemon.get());
		return true;
		
	}

	@Override
	public Optional<Pokemon> findById(Long id) {
		// TODO Auto-generated method stub
		return pokemonRepository.findById(id);
	}

}
