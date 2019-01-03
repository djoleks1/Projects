package vp.spring.rcs.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vp.spring.rcs.model.ComputerPart;

@Repository
public interface ComputerPartRepository extends JpaRepository<ComputerPart, Long> {

}
