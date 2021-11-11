package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Employee;

public interface IEmployeeRepository {

	List<Employee> getAllEmployees();

	Employee getEmployeeById(Long id);

	boolean addEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean deleteEmployee(Long id);

}
