package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Customer;
import com.api.rest.repository.interfaces.ICustomerRepository;

public class CustomerRepository implements ICustomerRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Customer> getAllCustomers() {
		EntityManager em = factory.createEntityManager();
		List<Customer> customers = null;
		String hql = "SELECT c FROM Customer c";
		try {
			TypedQuery<Customer> query = em.createQuery(hql, Customer.class);
			customers = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return customers;
	}

	@Override
	public Customer getCustomerById(Long id) {
		EntityManager em = factory.createEntityManager();
		Customer customer = null;
		try {
			customer = em.find(Customer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return customer;
	}

	@Override
	public boolean addCustomer(Customer customer) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(customer);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			bool = false;
		} finally {
			em.close();
			factory.close();
		}
		return bool;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(customer);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			bool = false;
		} finally {
			em.close();
			factory.close();
		}
		return bool;
	}

	@Override
	public boolean deleteCustomer(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Customer customer = em.find(Customer.class, id);
			em.getTransaction().begin();
			em.remove(customer);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			bool = false;
		} finally {
			em.close();
			factory.close();
		}
		return bool;
	}

	@Override
	public Customer getCustomerByDni(String dni) {
		EntityManager em = factory.createEntityManager();
		Customer customer = null;
		String hql = "SELECT c FROM Customer c where c.dni=?1";
		try {
			TypedQuery<Customer> query = em.createQuery(hql, Customer.class);
			query.setParameter(1, dni);

			customer = query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return customer;
	}

}
