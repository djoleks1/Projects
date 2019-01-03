package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Karta;

@Repository
public interface KartaRepositoty extends JpaRepository<Karta, Long> {

}
