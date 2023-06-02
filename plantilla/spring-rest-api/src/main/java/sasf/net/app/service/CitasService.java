package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Citas;

public interface CitasService {

	
	public Optional<Citas> findOneEntityById(Long id);
	
	public List<Citas> findAllEntity();

	public Citas saveEntity(Citas citas);
	
	public boolean deleteEntity(Long id);
}
