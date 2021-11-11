package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Employee;
import com.api.rest.repository.interfaces.IEmployeeRepository;

public class EmployeeRepository implements IEmployeeRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Employee> getAllEmployees() {
		EntityManager em = factory.createEntityManager();
		List<Employee> employees = null;
		String hql = "SELECT e FROM Employee e";
		try {
			TypedQuery<Employee> query = em.createQuery(hql, Employee.class);
			employees = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return employees;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		EntityManager em = factory.createEntityManager();
		Employee employee = null;
		try {
			employee = em.find(Employee.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return employee;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(employee);
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
	public boolean updateEmployee(Employee employee) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(employee);
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
	public boolean deleteEmployee(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Employee employee = em.find(Employee.class, id);
			em.getTransaction().begin();
			em.remove(employee);
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

}
