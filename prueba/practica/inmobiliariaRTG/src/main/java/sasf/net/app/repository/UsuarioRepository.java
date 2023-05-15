package sasf.net.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sasf.net.app.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
