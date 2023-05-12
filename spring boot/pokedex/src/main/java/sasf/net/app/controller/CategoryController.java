package sasf.net.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.Category;

import sasf.net.app.service.CategoryService;



@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService; 
	
	// read all pokemon
		@GetMapping
		public List<Category> readAll() {
			try {
				return  categoryService.findAllCategory();
			} catch (Exception e) {
				System.out.println(e);
				
				return null;
			}
		}
		
		

}
