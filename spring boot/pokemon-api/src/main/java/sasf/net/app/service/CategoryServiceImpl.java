package sasf.net.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sasf.net.app.entity.Category;
import sasf.net.app.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Iterable<Category> findAllCategory() {
		return categoryRepository.findAll();
	}

	@Override
	public Optional<Category> findByIdCategory(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
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
