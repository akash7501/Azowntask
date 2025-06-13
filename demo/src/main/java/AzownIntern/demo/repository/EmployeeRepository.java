package AzownIntern.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import AzownIntern.demo.entity.Employee;


@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long>{

}
