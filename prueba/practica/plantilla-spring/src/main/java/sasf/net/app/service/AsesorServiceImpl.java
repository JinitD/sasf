package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Asesor;
import sasf.net.app.repository.AsesorRepository;

@Service
public class AsesorServiceImpl implements AsesorService {

	@Autowired
	private AsesorRepository asesorRepository;

	@Override
	public List<Asesor> findAll() {
		// TODO Auto-generated method stub
		return asesorRepository.findAll();
	}

	@Override
	public Asesor save(Asesor asesor) {
		// TODO Auto-generated method stub
		return asesorRepository.save(asesor);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Asesor> res = asesorRepository.findById(id);
		if (res != null) {
			asesorRepository.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public Optional<Asesor> findById(Long id) {
		// TODO Auto-generated method stub
		return asesorRepository.findById(id);
	}

}
