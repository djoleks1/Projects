package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.TipKarte;

@Repository
public interface TipKarteRepository extends JpaRepository<TipKarte, Long> {

}
