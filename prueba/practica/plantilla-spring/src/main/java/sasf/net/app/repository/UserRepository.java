package sasf.net.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sasf.net.app.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{

}
