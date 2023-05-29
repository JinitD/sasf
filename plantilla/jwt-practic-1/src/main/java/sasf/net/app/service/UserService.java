package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.User;

public interface UserService {
	
	
	public Optional<User> findById(Long id);


	public List<User> findAllUsers();

	public User save(User user);
}
