package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Citas;
import sasf.net.app.entity.Users;
import sasf.net.app.repository.CitasRepository;

@Service
public class CitasServiceImpl implements CitasService{
	@Autowired
	private CitasRepository citasRepository; 

	@Override
	public Optional<Citas> findOneEntityById(Long id) {
		return citasRepository.findById(id);
	}

	@Override
	public List<Citas> findAllEntity() {
		return citasRepository.findAll();
	}

	@Override
	public Citas saveEntity(Citas citas) {
		return citasRepository.save(citas);
	}

	@Override
	public boolean deleteEntity(Long id) {
		Optional <Citas> oEntitny = findOneEntityById(id);
		if(!oEntitny.isPresent()) {
			return false;
		}
		oEntitny.get().setStatus("N");
		saveEntity(oEntitny.get());
		return true;
	}

}
