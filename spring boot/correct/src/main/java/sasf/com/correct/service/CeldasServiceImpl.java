package sasf.com.correct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.com.correct.entity.Celda;
import sasf.com.correct.repository.CeldasRepository;


@Service
public class CeldasServiceImpl implements CeldasService{
	@Autowired
	private CeldasRepository  celdasRepository ;

	@Override
	public List<Celda> findAll() {
		// TODO Auto-generated method stub
		return celdasRepository.findAll();
	}

	@Override
	public Optional<Celda> findById(Long id) {
		// TODO Auto-generated method stub
		return celdasRepository.findById(id);
	}

	@Override
	public Celda save(Celda celdas) {
		// TODO Auto-generated method stub
		return celdasRepository.save(celdas);
	}

}
