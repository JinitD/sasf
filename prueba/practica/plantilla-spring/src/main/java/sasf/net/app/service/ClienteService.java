package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.Cliente;

public interface ClienteService {
	
	public List<Cliente> findAll();

	public Cliente save(Cliente cliente);
	
	public Boolean deleteById(Long id);
	
	public Optional<Cliente> findById(Long id);

}
