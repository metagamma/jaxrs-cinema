package com.api.rest.resource;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.api.rest.entity.Employee;
import com.api.rest.repository.EmployeeRepository;
import com.api.rest.repository.interfaces.IEmployeeRepository;

@Path("employees")

public class EmployeeResource {

	private IEmployeeRepository employeeRepository;

	/*
	 * Method to get all employees
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEmployees() {
		employeeRepository = new EmployeeRepository();
		List<Employee> employees = employeeRepository.getAllEmployees();
		if (!employees.isEmpty()) {
			return Response.ok(employees).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get an employee by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEmployeeById(@PathParam("id") Long id) {
		employeeRepository = new EmployeeRepository();
		Employee employee = employeeRepository.getEmployeeById(id);
		if (employee.getEmpleado_id() != null) {
			return Response.ok(employee).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add an employee
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee employee) {
		employeeRepository = new EmployeeRepository();
		boolean bool = employeeRepository.addEmployee(employee);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update an employee
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(Employee employee) {
		employeeRepository = new EmployeeRepository();
		boolean bool = employeeRepository.updateEmployee(employee);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete an employee by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEmployee(@PathParam("id") Long id) {
		employeeRepository = new EmployeeRepository();
		boolean bool = employeeRepository.deleteEmployee(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}
	
}
