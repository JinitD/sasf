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
	public Optional<Users> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<Users> findAllUsers() {
		return userRepository.findAllByStatusNot("N");
	}

	@Override
	public Users save(Users users) {
		return userRepository.save(users);
	}

}
