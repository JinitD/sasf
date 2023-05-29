package sasf.com.correct.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sasf.com.correct.entity.Celda;
import sasf.com.correct.service.CeldasService;



@Controller
@RestController
@RequestMapping("/api/celda")
public class CeldasController {
	@Autowired
	private CeldasService  celdasService;
	

	//create a new user
		@PostMapping
		public ResponseEntity<?> create(@RequestBody Celda entity){
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(celdasService.save(entity));
		}
		
		//read an user
		@GetMapping("/{id}")
		public ResponseEntity<?> read(@PathVariable Long id){
			Optional<Celda> oEntity  = celdasService.findById(id);
			if(!oEntity.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(oEntity);
			
		}
		//update an user
		@PutMapping("/{id}")
		public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Celda entityPut) {
			Optional<Celda> oEntity = celdasService.findById(id);
			if (!oEntity.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			oEntity = Optional.ofNullable(entityPut);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(celdasService.save(oEntity.get()));

		}
		
		//read all user
		@GetMapping
		public ResponseEntity<?> readAll(){
			try {
				return ResponseEntity.status(HttpStatus.OK).body(celdasService.findAll());
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
			
		}}
}
