package sasf.com.correct.service;

import java.util.List;
import java.util.Optional;

import sasf.com.correct.entity.Celda;


public interface CeldasService {

	
	public List<Celda> findAll();

	public Optional<Celda> findById(Long id);

	public Celda save(Celda celdas);
}
