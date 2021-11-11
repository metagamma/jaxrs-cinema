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
import com.api.rest.entity.Customer;
import com.api.rest.repository.CustomerRepository;
import com.api.rest.repository.interfaces.ICustomerRepository;

@Path("customers")

public class CustomerResource {

	private ICustomerRepository customerRepository;

	/*
	 * Method to get all customers
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCustomers() {
		customerRepository = new CustomerRepository();
		List<Customer> customers = customerRepository.getAllCustomers();
		if (!customers.isEmpty()) {
			return Response.ok(customers).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a customer by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerById(@PathParam("id") Long id) {
		customerRepository = new CustomerRepository();
		Customer customer = customerRepository.getCustomerById(id);
		if (customer.getCliente_id() != null) {
			return Response.ok(customer).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a customer
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCustomer(Customer customer) {
		customerRepository = new CustomerRepository();
		boolean bool = customerRepository.addCustomer(customer);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a customer
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCustomer(Customer customer) {
		customerRepository = new CustomerRepository();
		boolean bool = customerRepository.updateCustomer(customer);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a customer by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteCustomer(@PathParam("id") Long id) {
		customerRepository = new CustomerRepository();
		boolean bool = customerRepository.deleteCustomer(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	@Path("/dni/{dni}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCustomerByDni(@PathParam("dni") String dni) {
		customerRepository = new CustomerRepository();
		Customer customer = customerRepository.getCustomerByDni(dni);
		if (customer.getCliente_id() != null) {
			return Response.ok(customer).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
