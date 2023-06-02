package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Users;
import sasf.net.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	

	@Override
	public Optional<Users> findOneEntityById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<Users> findAllEntity() {
		return userRepository.findAllByStatusNot("N");
	}

	@Override
	public Users saveEntity(Users users) {
		return userRepository.save(users);
	}

	@Override
	public boolean deleteEntity(Long id) {
		Optional <Users> oUser = findOneEntityById(id);
		if(!oUser.isPresent()) {
			return false;
		}
		oUser.get().setStatus("N");
		saveEntity(oUser.get());
		
		return true;
	}

	@Override
	public Optional<Users> findOneEntityByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findOneByEmail(email);
	}

}
