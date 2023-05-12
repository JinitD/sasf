package sasf.net.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sasf.net.app.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
