package sasf.net.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.AreaConocimineto;
import sasf.net.app.service.AreacConciminetoService;

@RestController
@RequestMapping("/api/privade/areaCo")
public class AreacConciminetoController {
	@Autowired
	private AreacConciminetoService entityService; 
	
	
	@GetMapping
	@ResponseBody
	public  ResponseEntity<?>  findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(entityService.findAllEntity());
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<?> findById(@PathVariable Long id ){
		
		Optional<AreaConocimineto> oEntitiy = entityService.findOneEntityById(id);
		if (!oEntitiy.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(oEntitiy.get());
	}

}
