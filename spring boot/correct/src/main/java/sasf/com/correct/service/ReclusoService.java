package sasf.com.correct.service;

import java.util.List;
import java.util.Optional;

import sasf.com.correct.entity.Recluso;


public interface ReclusoService {

	public List<Recluso> findAll();

	public Optional<Recluso> findById(Long id);

	public Recluso save(Recluso recluso);

}
