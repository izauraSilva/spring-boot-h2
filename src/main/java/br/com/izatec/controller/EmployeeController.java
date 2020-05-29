package br.com.izatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.izatec.models.Employee;
import br.com.izatec.parameter.EmployeeParameter;
import br.com.izatec.presenters.EmployeePresenter;
import br.com.izatec.services.EmployeeService;
 
/**
 * @author IZAURA SILVA
 *
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
    @Autowired
    EmployeeService service;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<EmployeePresenter> create(@RequestBody EmployeeParameter request) throws Exception {

    	try {

    		Employee employee = service.create(request.toModel());

    		if (employee != null && employee.getId() != null) {
    			return new ResponseEntity(new EmployeePresenter(employee), HttpStatus.CREATED);
    		} else if (employee == null) {
    			return new ResponseEntity(HttpStatus.NO_CONTENT);
    		} else {
    			return new ResponseEntity(HttpStatus.NOT_FOUND);
    		}

    	} catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    	}
    }
    
  
    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Page<Employee>> getByCustomerDocumentPaged(
    		@RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            @RequestParam(value = "sortBy", required = false, defaultValue = "id") String sortBy,
            @RequestParam(value = "order", required = false, defaultValue = "desc") String order) {

    	EmployeeParameter parameter = new EmployeeParameter();
        parameter.setPage(page);
        parameter.setSize(size);
        parameter.setSortBy(sortBy);
        parameter.setOrder(order);

        Page<Employee> employeePageationPage = this.service.getAllPaged(parameter.toModel());

        if (employeePageationPage != null && employeePageationPage.getTotalElements() > 0) {
            Page<EmployeePresenter> ManifestationPresenter = employeePageationPage.map(a -> new EmployeePresenter(a));
            return new ResponseEntity(ManifestationPresenter, HttpStatus.OK);
        } else if (employeePageationPage == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity getById(@PathVariable Long id) throws Exception {

    	Employee protocol = this.service.findById(id);

        if (protocol != null && protocol.getId() != null) {
        	EmployeePresenter protocolPresenter = new EmployeePresenter(protocol);
            return new ResponseEntity(protocolPresenter, HttpStatus.OK);
        } else if (protocol == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
 
}