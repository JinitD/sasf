package sasf.net.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Category;
import sasf.net.app.repository.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository  categoryRepository;

	@Override
	public List<Category> findAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByIdCategory(Long id) {
		// TODO Auto-generated method stub
		
	}

}
