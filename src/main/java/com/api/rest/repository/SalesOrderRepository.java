package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.SalesOrder;
import com.api.rest.repository.interfaces.ISalesOrderRepository;

public class SalesOrderRepository implements ISalesOrderRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<SalesOrder> getAllSalesOrders() {
		EntityManager em = factory.createEntityManager();
		List<SalesOrder> salesOrders = null;
		String hql = "SELECT s FROM SalesOrder s";
		try {
			TypedQuery<SalesOrder> query = em.createQuery(hql, SalesOrder.class);
			salesOrders = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return salesOrders;
	}

	@Override
	public SalesOrder getSalesOrderById(Long id) {
		EntityManager em = factory.createEntityManager();
		SalesOrder salesOrder = null;
		try {
			salesOrder = em.find(SalesOrder.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return salesOrder;
	}

	@Override
	public boolean addSalesOrder(SalesOrder salesOrder) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(salesOrder);
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
	public boolean updateSalesOrder(SalesOrder salesOrder) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(salesOrder);
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
	public boolean deleteSalesOrder(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			SalesOrder salesOrder = em.find(SalesOrder.class, id);
			em.getTransaction().begin();
			em.remove(salesOrder);
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
	public List<SalesOrder> listarReservasxCodigo(String cod) {
		EntityManager em = factory.createEntityManager();
		List<SalesOrder> data = null;
		TypedQuery<SalesOrder>resul=null;
		try {
			String hql = "SELECT s FROM SalesOrder s where s.codigo_reserva =?1";
			resul=em.createQuery(hql,SalesOrder.class);
			resul.setParameter(1, cod);
			data=resul.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return data;
	}

}
