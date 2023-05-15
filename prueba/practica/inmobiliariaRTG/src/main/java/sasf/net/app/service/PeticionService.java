package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Peticion;

public interface PeticionService {

	public Optional<Peticion> findById(Long id);

	public List<Peticion> findAllByStatus(char status);
	
	public List<Peticion> findAll();

	public Peticion save(Peticion peticion);

	public Boolean updateById(Long id,char status);
}
