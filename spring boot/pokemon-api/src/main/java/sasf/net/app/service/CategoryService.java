package sasf.net.app.service;

import java.util.Optional;

import sasf.net.app.entity.Category;

public interface CategoryService {
	public Iterable<Category> findAllCategory();

	public Optional<Category> findByIdCategory(Long id);

	public Category saveCategory(Category category);

	public void deleteByIdCategory(Long id);
}
