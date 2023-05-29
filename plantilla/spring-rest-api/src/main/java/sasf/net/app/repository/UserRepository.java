package sasf.net.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sasf.net.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findOneByEmail(String email);
	
	List<User> findAllByStatusNot(String status);
}
