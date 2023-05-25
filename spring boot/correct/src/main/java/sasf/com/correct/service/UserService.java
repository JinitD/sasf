package sasf.com.correct.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sasf.com.correct.entity.User;


public interface UserService {
	
	public List<User> findAll();
	
	public Page<User> findAll(Pageable pagenable);
	
	public Optional<User> findById(Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);
}
