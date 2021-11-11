package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Film;
import com.api.rest.repository.interfaces.IFilmRepository;

public class FilmRepository implements IFilmRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Film> getAllFilms() {
		EntityManager em = factory.createEntityManager();
		List<Film> films = null;
		String hql = "SELECT f FROM Film f";
		try {
			TypedQuery<Film> query = em.createQuery(hql, Film.class);
			films = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return films;
	}

	@Override
	public Film getFilmById(Long id) {
		EntityManager em = factory.createEntityManager();
		Film film = null;
		try {
			film = em.find(Film.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return film;
	}

	@Override
	public boolean addFilm(Film film) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(film);
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
	public boolean updateFilm(Film film) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(film);
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
	public boolean deleteFilm(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Film film = em.find(Film.class, id);
			em.getTransaction().begin();
			em.remove(film);
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
