package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Inmueble;

public interface InmuebleService {

	public Optional<Inmueble> findById(Long id);

	public List<Inmueble> findAll();

	public Inmueble save(Inmueble inmueble);

	
	public Boolean updateById(Long id,char status);
}
