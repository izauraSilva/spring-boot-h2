package br.com.izatec.parameter;

import java.io.Serializable;

import br.com.izatec.models.Employee;

/**
 * @author IZAURA SILVA
 *
 */
public class EmployeeParameter implements Serializable, GenericParameter<Employee> {
   
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstName;
    private String lastName;
    private String email;
    private int page;
	private int size;
	private String sortBy;
	private String order;
   
    @Override
	public Employee toModel() {
    	Employee employee = new Employee();
    	employee.setId(this.getId());
    	employee.setFirstName(this.firstName);
    	employee.setLastName(this.lastName);
    	employee.setEmail(this.email);
    	employee.setSize(this.size);
    	employee.setPage(this.page);
    	employee.setSortBy(this.sortBy);
    	employee.setOrder(this.order);
		return employee;
	}   
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}	
}