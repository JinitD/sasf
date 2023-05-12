package sasf.net.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sasf.net.app.entity.Inmueble;


public interface InmuebleRepository extends JpaRepository<Inmueble, Long>{
	
	@Query("SELECT i FROM Inmueble i WHERE i.estado <> 'r'")
	List<Inmueble> findAllForStatus();
	
}
