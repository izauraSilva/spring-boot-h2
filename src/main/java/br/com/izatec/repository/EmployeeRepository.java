package br.com.izatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.izatec.entities.EmployeeEntity;
 
/**
 * @author IZAURA SILVA
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
 
}
