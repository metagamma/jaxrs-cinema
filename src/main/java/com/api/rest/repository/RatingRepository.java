package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Rating;
import com.api.rest.repository.interfaces.IRatingRepository;

public class RatingRepository implements IRatingRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Rating> getAllRatings() {
		EntityManager em = factory.createEntityManager();
		List<Rating> ratings = null;
		String hql = "SELECT r FROM Rating r";
		try {
			TypedQuery<Rating> query = em.createQuery(hql, Rating.class);
			ratings = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return ratings;
	}

	@Override
	public Rating getRatingById(Long id) {
		EntityManager em = factory.createEntityManager();
		Rating rating = null;
		try {
			rating = em.find(Rating.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return rating;
	}

	@Override
	public boolean addRating(Rating rating) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(rating);
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
	public boolean updateRating(Rating rating) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(rating);
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
	public boolean deleteRating(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Rating rating = em.find(Rating.class, id);
			em.getTransaction().begin();
			em.remove(rating);
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
