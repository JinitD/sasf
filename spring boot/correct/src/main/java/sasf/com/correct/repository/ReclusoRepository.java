package sasf.com.correct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sasf.com.correct.entity.Recluso;


@Repository
public interface ReclusoRepository extends JpaRepository<Recluso, Long>{

}
