package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Usuario;


public interface UsuarioService {
	

	public Optional<Usuario> findById(Long id);
	
	public Optional<Usuario> findByRol(String rol);
	
	public List<Usuario> findAll();

	public Usuario save(Usuario Usuario);

	
}
