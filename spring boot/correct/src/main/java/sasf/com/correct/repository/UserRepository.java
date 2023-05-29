package sasf.com.correct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sasf.com.correct.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
