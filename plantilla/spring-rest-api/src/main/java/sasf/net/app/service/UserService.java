package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Users;

public interface UserService {
	
	
	public Optional<Users> findOneEntityById(Long id);
	
	public Optional<Users> findOneEntityByEmail(String email);

	public List<Users> findAllEntity();

	public Users saveEntity(Users users);
	
	public boolean deleteEntity(Long id);
}
