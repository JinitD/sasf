package sasf.net.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.Usuario;
import sasf.net.app.service.UsuarioService;


@Controller
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService  usuarioService;
	
	@GetMapping
	@ResponseBody
	public List<Usuario> findAll(){
		return usuarioService.findAll();
	}

}
