package AzownIntern.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AzownIntern.demo.entity.Employee;
import AzownIntern.demo.repository.EmployeeRepository;



@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee employee) {
		return  employeeRepository.save(employee);
	}

	
	public  List<Employee> ListOffTheEmployees() {
		return employeeRepository.findAll();
	}
	
	
	public Optional<Employee> employeeDetails(long id) {
	return employeeRepository.findById(id);
	}
	
	

	public Employee editEmployeeDetails(Employee employee, long id) {
		Optional <Employee> optional =employeeRepository.findById(id);
		if(optional.isPresent()) {
		Employee dbEmployee =optional.get();
			if(employee.getName()!=null) {
				dbEmployee .setName(employee.getName());
				}
			if(employee.getEmail()!=null) {
				dbEmployee.setEmail(employee.getEmail());
				}
	
			employee=employeeRepository.save(dbEmployee);
		}
		return employee;	
	}

	
	
	public String deleteOwnerDetailsById(Long id) {
		    Optional<Employee>opOwner=employeeRepository.findById(id);
		    if(opOwner.isPresent()) {
             employeeRepository.deleteById(id);
		    	return "Employee  deleted successfully !";
		    }
		    else {
		    	return "Employee  Record does npt exist";
		    }
	}

	
}
