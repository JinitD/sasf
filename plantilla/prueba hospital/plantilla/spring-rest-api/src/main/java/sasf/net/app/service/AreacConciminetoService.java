package sasf.net.app.service;

import java.util.List;
import java.util.Optional;

import sasf.net.app.entity.AreaConocimineto;

public interface AreacConciminetoService {

	
public Optional<AreaConocimineto> findOneEntityById(Long id);
	
	public List<AreaConocimineto> findAllEntity();
}
