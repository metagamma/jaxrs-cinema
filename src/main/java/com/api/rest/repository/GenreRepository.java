package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Genre;
import com.api.rest.repository.interfaces.IGenreRepository;

public class GenreRepository implements IGenreRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Genre> getAllGenres() {
		EntityManager em = factory.createEntityManager();
		List<Genre> genres = null;
		String hql = "SELECT g FROM Genre g";
		try {
			TypedQuery<Genre> query = em.createQuery(hql, Genre.class);
			genres = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return genres;
	}

	@Override
	public Genre getGenreById(Long id) {
		EntityManager em = factory.createEntityManager();
		Genre genre = null;
		try {
			genre = em.find(Genre.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return genre;
	}

	@Override
	public boolean addGenre(Genre genre) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(genre);
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
	public boolean updateGenre(Genre genre) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(genre);
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
	public boolean deleteGenre(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Genre genre = em.find(Genre.class, id);
			em.getTransaction().begin();
			em.remove(genre);
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
