package sasf.com.correct.service;

import java.util.List;
import java.util.Optional;

import sasf.com.correct.entity.Pabellon;
import sasf.com.correct.entity.DTO.PabellonDTO;


public interface PabellonesService {
	public List<Pabellon> findAll();

	public Optional<Pabellon> findById(Long id);

	public Pabellon save(PabellonDTO pabellonDto);
}
