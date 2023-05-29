package sasf.net.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import sasf.net.app.service.UserService;


@Controller
@RestController
@RequestMapping("/api/privade/users")
@AllArgsConstructor
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	@ResponseBody
	public  ResponseEntity<?>  findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUsers());
	}
}
