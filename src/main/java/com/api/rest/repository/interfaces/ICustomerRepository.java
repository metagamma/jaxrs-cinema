package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Customer;

public interface ICustomerRepository {

	List<Customer> getAllCustomers();

	Customer getCustomerById(Long id);

	Customer getCustomerByDni(String dni);

	boolean addCustomer(Customer customer);

	boolean updateCustomer(Customer customer);

	boolean deleteCustomer(Long id);

}