package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Format;
import com.api.rest.repository.interfaces.IFormatRepository;

public class FormatRepository implements IFormatRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Format> getAllFormats() {
		EntityManager em = factory.createEntityManager();
		List<Format> formats = null;
		String hql = "SELECT f FROM Format f";
		try {
			TypedQuery<Format> query = em.createQuery(hql, Format.class);
			formats = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return formats;
	}

	@Override
	public Format getFormatById(Long id) {
		EntityManager em = factory.createEntityManager();
		Format format = null;
		try {
			format = em.find(Format.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return format;
	}

	@Override
	public boolean addFormat(Format format) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(format);
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
	public boolean updateFormat(Format format) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(format);
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
	public boolean deleteFormat(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Format format = em.find(Format.class, id);
			em.getTransaction().begin();
			em.remove(format);
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
