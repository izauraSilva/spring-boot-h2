package br.com.izatec.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.izatec.models.Employee;

/**
 * @author IZAURA SILVA
 *
 */
@Entity
@Table(name="TBL_EMPLOYEES")
public class EmployeeEntity implements Serializable {
		
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="first_name")
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email", nullable=false, length=200)
    private String email; 
  
    public EmployeeEntity() {
		
	}

	public EmployeeEntity(Employee employee) {
		if(employee!=null) {
			this.id = employee.getId();
			this.firstName = employee.getFirstName();
			this.lastName = employee.getLastName();
			this.email = employee.getEmail();
		}		
	}
	
	public Employee toModel() {		
		Employee employee = new Employee();
		employee.setId(this.id);
		employee.setFirstName(this.firstName);
		employee.setLastName(this.lastName);
		employee.setEmail(this.email);
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

    @Override
    public String toString() {
        return "EmployeeEntity [id=" + id + ", firstName=" + firstName + 
                ", lastName=" + lastName + ", email=" + email   + "]";
    }
}