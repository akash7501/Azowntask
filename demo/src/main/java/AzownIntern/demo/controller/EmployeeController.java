package AzownIntern.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import AzownIntern.demo.entity.Employee;
import AzownIntern.demo.service.EmployeeService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);	
	}
	
	@GetMapping("/employee")
	public List<Employee> ListOfTheEmployee(){
		return  employeeService.ListOffTheEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Optional<Employee> findEmployee(@PathVariable long id) {
		return employeeService.employeeDetails(id);
	}
	
	@PutMapping("/employee")
	public Employee UpdateEmployeeDetails( @RequestBody Employee employee,@RequestParam  long id) {
	return employeeService.editEmployeeDetails(employee,id);
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteOwnerDetails(@PathVariable Long id) {
		return employeeService.deleteOwnerDetailsById(id);
	}

}
