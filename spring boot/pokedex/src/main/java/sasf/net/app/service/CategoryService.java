package sasf.net.app.service;

import java.util.List;

import sasf.net.app.entity.Category;



public interface CategoryService {
	
	public List<Category> findAllCategory();
	
	public Category saveCategory(Category category);
	
	public void deleteByIdCategory(Long id);

}
