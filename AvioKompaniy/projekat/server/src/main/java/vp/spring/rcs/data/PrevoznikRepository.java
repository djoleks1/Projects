package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.Prevoznik;
@Repository
public interface PrevoznikRepository extends JpaRepository<Prevoznik, Long> {

}
