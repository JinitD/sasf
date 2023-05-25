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

import sasf.com.correct.entity.Pabellon;
import sasf.com.correct.service.PabellonesService;


@Controller
@RestController
@RequestMapping("/api/pabellon")
public class PabellonesController {

	@Autowired
	private PabellonesService  pabellonesService;
	
	
	//create a new user
		@PostMapping
		public ResponseEntity<?> create(@RequestBody Pabellon entity){
			return ResponseEntity.status(HttpStatus.CREATED).body(pabellonesService.save(entity));
		}
		
		//read an user
		@GetMapping("/{id}")
		public ResponseEntity<?> read(@PathVariable Long id){
			Optional<Pabellon> oEntity  = pabellonesService.findById(id);
			if(!oEntity.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(oEntity);
			
		}
		//update an user
		@PutMapping("/{id}")
		public ResponseEntity<?> put(@PathVariable Long id, @RequestBody Pabellon entityPut) {
			Optional<Pabellon> oEntity = pabellonesService.findById(id);
			if (!oEntity.isPresent()) {
				return ResponseEntity.notFound().build();
			}
			oEntity = Optional.ofNullable(entityPut);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(pabellonesService.save(oEntity.get()));

		}
		
		//read all user
		@GetMapping
		public ResponseEntity<?> readAll(){
			try {
				return ResponseEntity.status(HttpStatus.OK).body(pabellonesService.findAll());
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
			
		}}
}
