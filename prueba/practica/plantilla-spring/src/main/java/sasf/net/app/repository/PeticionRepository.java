package sasf.net.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sasf.net.app.entity.Peticion;

public interface PeticionRepository extends JpaRepository<Peticion, Long> {

}
