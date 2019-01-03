package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;

import vp.spring.rcs.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
