package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Usuario;
import sasf.net.app.repository.UsuarioRepository;


@Service
public class UsuarioServiceImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findById(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id);
		
	}

	@Override
	public Optional<Usuario> findByRol(String rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(usuario);
	}

	
	
	

}
