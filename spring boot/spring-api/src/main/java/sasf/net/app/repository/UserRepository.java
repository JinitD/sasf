package sasf.net.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sasf.net.app.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
