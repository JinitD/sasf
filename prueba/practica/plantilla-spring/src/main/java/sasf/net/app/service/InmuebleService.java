package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Inmueble;

public interface InmuebleService {
	
	public List<Inmueble> findAll();
	
	public List<Inmueble> findAllByStatus();

	public Inmueble save(Inmueble inmueble);
	
	public Boolean deleteById(Long id);
	
	public Optional<Inmueble> findById(Long id);

}
