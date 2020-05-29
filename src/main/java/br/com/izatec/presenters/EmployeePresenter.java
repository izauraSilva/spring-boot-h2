package br.com.izatec.presenters;

import java.io.Serializable;

import br.com.izatec.models.Employee;


/**
 * @author IZAURA SILVA
 *
 */
public class EmployeePresenter implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;	 
	private String firstName;	
	private String lastName;	 
	private String email;	
	
	public EmployeePresenter(Employee employee) {
		if(employee!=null) {
			this.id = employee.getId();
			this.firstName = employee.getFirstName();
			this.lastName = employee.getLastName();
			this.email = employee.getEmail();
		}		
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

}
