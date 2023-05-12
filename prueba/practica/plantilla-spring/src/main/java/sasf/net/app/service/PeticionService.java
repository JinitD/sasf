package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Peticion;
public interface PeticionService {
	
	public List<Peticion> findAll();

	public Peticion save(Peticion peticion);
	
	public Boolean deleteById(Long id);
	
	public Optional<Peticion> findById(Long id);
}
