package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Inmueble;
import sasf.net.app.repository.InmuebleRepository;

@Service
public class InmuebleServiceImpl implements InmuebleService {

	@Autowired
	private InmuebleRepository inmuebleRepository;

	@Override
	public List<Inmueble> findAll() {
		// TODO Auto-generated method stub
		return inmuebleRepository.findAll();
	}

	@Override
	public Inmueble save(Inmueble inmueble) {
		// TODO Auto-generated method stub
		return inmuebleRepository.save(inmueble);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Inmueble> res = inmuebleRepository.findById(id);
		if (res != null) {
			inmuebleRepository.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public Optional<Inmueble> findById(Long id) {
		// TODO Auto-generated method stub
		return inmuebleRepository.findById(id);
	}

	@Override
	public List<Inmueble> findAllByStatus() {
		// TODO Auto-generated method stub
		return inmuebleRepository.findAllForStatus();
	}

}
