package sasf.net.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import sasf.net.app.entity.Category;
import sasf.net.app.service.CategoryService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService  categoryService;
	
	@GetMapping("/category")
	@ResponseBody
	public Iterable<Category> readAllCategory(){
		return categoryService.findAllCategory();
	}
}
