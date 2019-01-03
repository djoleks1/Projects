package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
