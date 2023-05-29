package sasf.com.correct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.com.correct.entity.Pabellon;
import sasf.com.correct.entity.User;
import sasf.com.correct.entity.DTO.PabellonDTO;
import sasf.com.correct.repository.PabellonesRepository;
import sasf.com.correct.repository.UserRepository;


@Service
public class PabellonesServiceImpl implements PabellonesService {

	@Autowired
	private PabellonesRepository  pabellonesRepository ;
	
	@Autowired
	private UserRepository  userRepository ;
	
	@Override
	public List<Pabellon> findAll() {
		// TODO Auto-generated method stub
		return pabellonesRepository.findAll();
	}

	@Override
	public Optional<Pabellon> findById(Long id) {
		// TODO Auto-generated method stub
		return pabellonesRepository.findById(id);
	}

	@Override
	public Pabellon save(PabellonDTO pabellonDto) {
		Optional<User> Ovigilante = userRepository.findById(pabellonDto.getId_personal_vigilancia());
		if(Ovigilante.get() == null) {
			return null;
		}
		Pabellon newPabellon = new Pabellon(); 
		// TODO Auto-generated method stub
		return pabellonesRepository.save(pabellones);
	}

}
