package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Users;

public interface UserService {
	
	
	public Optional<Users> findById(Long id);


	public List<Users> findAllUsers();

	public Users save(Users users);
}
