package br.com.izatec.services;

import org.springframework.data.domain.Page;

import br.com.izatec.models.Employee;

/**
*
* @author Izaura Silva
*/
public interface EmployeeService {
	
	public Employee create(Employee employee);
	
	public Page<Employee> getAllPaged(Employee employee);

}
