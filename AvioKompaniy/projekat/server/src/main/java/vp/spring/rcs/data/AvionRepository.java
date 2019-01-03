package vp.spring.rcs.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Avion;
@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {

	public List<Avion> findByVremeLetaContains(String vreme);
}
