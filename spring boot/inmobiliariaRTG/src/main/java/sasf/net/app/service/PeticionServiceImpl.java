package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Peticion;
import sasf.net.app.repository.PeticionRepository;

@Service
public class PeticionServiceImpl implements  PeticionService{

	@Autowired
	private PeticionRepository peticionRepository;

	@Override
	public Optional<Peticion> findById(Long id) {
		// TODO Auto-generated method stub
		return peticionRepository.findById(id);
	}

	@Override
	public List<Peticion> findAllByStatus(char status) {
		// TODO Auto-generated method stub
		return null;//peticionRepository;
	}

	@Override
	public Peticion save(Peticion peticion) {
		// TODO Auto-generated method stub
		return peticionRepository.save(peticion);
	}

	@Override
	public Boolean updateById(Long id,char status) {
		Optional<Peticion> oInmue = findById(id);
		if (oInmue != null) {
			oInmue.get().setEstado(status);
			return true;
		}
		return false;
		
	}

	@Override
	public List<Peticion> findAll() {
		// TODO Auto-generated method stub
		return peticionRepository.findAll();
	}
	
	

	

}
