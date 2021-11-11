package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Director;
import com.api.rest.repository.interfaces.IDirectorRepository;

public class DirectorRepository implements IDirectorRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Director> getAllDirectors() {
		EntityManager em = factory.createEntityManager();
		List<Director> directors = null;
		String hql = "SELECT d FROM Director d";
		try {
			TypedQuery<Director> query = em.createQuery(hql, Director.class);
			directors = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return directors;
	}

	@Override
	public Director getDirectorById(Long id) {
		EntityManager em = factory.createEntityManager();
		Director director = null;
		try {
			director = em.find(Director.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return director;
	}

	@Override
	public boolean addDirector(Director director) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(director);
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
	public boolean updateDirector(Director director) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(director);
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
	public boolean deleteDirector(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Director director = em.find(Director.class, id);
			em.getTransaction().begin();
			em.remove(director);
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
