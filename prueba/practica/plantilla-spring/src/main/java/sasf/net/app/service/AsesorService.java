package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Asesor;



public interface AsesorService  {
	
	public List<Asesor> findAll();

	public Asesor save(Asesor asesor);
	
	public Boolean deleteById(Long id);
	
	public Optional<Asesor> findById(Long id);

}
