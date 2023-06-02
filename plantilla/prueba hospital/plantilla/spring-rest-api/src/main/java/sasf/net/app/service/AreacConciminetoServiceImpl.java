package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.AreaConocimineto;
import sasf.net.app.repository.AreacConciminetoRepository;

@Service
public class AreacConciminetoServiceImpl implements AreacConciminetoService {
	@Autowired
	private AreacConciminetoRepository areacConciminetoRepository;

	@Override
	public Optional<AreaConocimineto> findOneEntityById(Long id) {
		return areacConciminetoRepository.findById(id);
	}

	@Override
	public List<AreaConocimineto> findAllEntity() {
		// TODO Auto-generated method stub
		return areacConciminetoRepository.findAll();
	} 
	
	

}
