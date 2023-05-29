package sasf.com.correct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.com.correct.entity.Recluso;
import sasf.com.correct.repository.ReclusoRepository;


@Service
public class ReclusoServiceImpl implements ReclusoService{

	@Autowired
	private ReclusoRepository reclusoRepository;
	@Override
	public List<Recluso> findAll() {
		return reclusoRepository.findAll();
	}

	@Override
	public Optional<Recluso> findById(Long id) {
		// TODO Auto-generated method stub
		return reclusoRepository.findById(id);
	}

	@Override
	public Recluso save(Recluso recluso) {
		// TODO Auto-generated method stub
		return reclusoRepository.save(recluso);
	}


}
