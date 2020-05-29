package br.com.izatec.service.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.izatec.entities.EmployeeEntity;
import br.com.izatec.models.Employee;
import br.com.izatec.repository.EmployeeRepository;
import br.com.izatec.services.EmployeeService;

/**
 * @author IZAURA SILVA
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository repository;

	@Override
	public Employee create(Employee entity) {				
		Employee employee = this.repository.save(new EmployeeEntity(entity)).toModel();		
		return employee;
	}   

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Page<Employee> getAllPaged(Employee employee) {

		Pageable paging = null;

		if (!StringUtils.isEmpty(employee.getOrder()) && StringUtils.equalsIgnoreCase("desc", employee.getOrder().trim())) {
			paging = PageRequest.of(employee.getPage(), employee.getSize(), Sort.by(employee.getSortBy()).descending());
		} else {
			paging = PageRequest.of(employee.getPage(), employee.getSize(), Sort.by(employee.getSortBy()).ascending());
		}

		List<Employee> employees = this.repository.findAll(paging).stream().map(a -> a.toModel()).collect(toList());

		PagedListHolder pagedListHolder = new PagedListHolder(employees);

		Page<Employee> page = new PageImpl<>(pagedListHolder.getPageList());

		return page;
	}

	@Override
	public Employee findById(Long id) {
		
		EmployeeEntity employeeEntity = this.repository.getOne(id);
		
		if (employeeEntity != null) {
			return employeeEntity.toModel();
		} else {
			return null;
		}
	}

	@Override
	public Employee findByFirstName(String firstName) {
		
		EmployeeEntity employeeEntity = this.repository.findByFirstName(firstName);
		
		if (employeeEntity != null) {
			return employeeEntity.toModel();
		} else {
			return null;
		}
	}



}