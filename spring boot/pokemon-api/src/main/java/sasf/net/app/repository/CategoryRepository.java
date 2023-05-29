package sasf.net.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sasf.net.app.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
}
