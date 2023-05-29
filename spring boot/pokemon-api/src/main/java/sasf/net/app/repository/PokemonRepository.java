package sasf.net.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.app.entity.Pokemon;

public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
	@Query("SELECT p FROM Pokemon p WHERE p.status <> 'n'")
	List<Pokemon> findByStatus();
}
