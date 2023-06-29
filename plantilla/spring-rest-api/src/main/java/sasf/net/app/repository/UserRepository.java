package sasf.net.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sasf.net.app.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>{
	Optional<Users> findOneByEmail(String email);
	Optional<Users> findOneByUsername(String username);
	List<Users> findAllByStatusNot(String status);
}
