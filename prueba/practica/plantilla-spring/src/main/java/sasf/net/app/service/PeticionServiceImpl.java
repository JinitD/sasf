package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Peticion;
import sasf.net.app.repository.PeticionRepository;

@Service
public class PeticionServiceImpl implements PeticionService{
	
	@Autowired
	private PeticionRepository PeticionRepository;

	@Override
	public List<Peticion> findAll() {
		// TODO Auto-generated method stub
		return PeticionRepository.findAll();
	}

	@Override
	public Peticion save(Peticion peticion) {
		// TODO Auto-generated method stub
		return PeticionRepository.save(peticion);
	}

	@Override
	public Boolean deleteById(Long id) {
		// TODO Auto-generated method stub
		Optional<Peticion> res = PeticionRepository.findById(id);
		if (res != null) {
			PeticionRepository.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public Optional<Peticion> findById(Long id) {
		// TODO Auto-generated method stub
		return PeticionRepository.findById(id);
	}

}
