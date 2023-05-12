package sasf.net.app.service;

import java.util.List;

import sasf.net.app.entity.User;

public interface UserService {
	public List<User> findAllUser();

	public User saveUser(User User);

	public void deleteByIdCategory(Long id);
}
