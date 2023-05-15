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

import sasf.net.app.entity.Inmueble;
import sasf.net.app.service.InmuebleService;

@Controller
@RestController
@RequestMapping("/api/inmueble")
public class InmuebleController {

	@Autowired
	private InmuebleService  inmuebleService;
	
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<Inmueble> findById(@PathVariable Long id ){
		return inmuebleService.findById(id);
	}
	
	@GetMapping
	@ResponseBody
	public List<Inmueble> findAll(){
		return inmuebleService.findAll();
		}
}
