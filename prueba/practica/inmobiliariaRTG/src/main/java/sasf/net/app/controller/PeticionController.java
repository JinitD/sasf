package sasf.net.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.Peticion;
import sasf.net.app.service.PeticionService;

@Controller
@RestController
@RequestMapping("/api/peticion")
public class PeticionController {

	@Autowired
	private PeticionService  peticionService;
	
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Peticion> findById(@PathVariable Long id ){
		return peticionService.findById(id);
	}
	
	@GetMapping
	@ResponseBody
	public List<Peticion> findAll(){
		return peticionService.findAll();
		}
	
}
