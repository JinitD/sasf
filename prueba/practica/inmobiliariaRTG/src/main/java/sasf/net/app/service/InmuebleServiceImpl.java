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
	public Optional<Inmueble> findById(Long id) {
		return inmuebleRepository.findById(id);
	}

	@Override
	public List<Inmueble> findAll() {
		return inmuebleRepository.findAll();
	}

	@Override
	public Inmueble save(Inmueble inmueble) {
		return inmuebleRepository.save(inmueble);
	}	

	@Override
	public Boolean updateById(Long id,char status) {
		Optional<Inmueble> oInmue = findById(id);
		if (oInmue != null) {
			oInmue.get().setEstado(status);
			return true;
		}
		return false;
	}
	
	

}
