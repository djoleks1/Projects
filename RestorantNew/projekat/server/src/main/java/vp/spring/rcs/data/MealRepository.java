package vp.spring.rcs.data;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {

	public Page<Meal> findAll(Pageable pageable);
	
	public List<Meal> findByNameContains(String mealName);
	
	List<Meal> findByCategoryNameContains(String categoryName);
	
}
