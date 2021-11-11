package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Showtime;
import com.api.rest.repository.interfaces.IShowtimeRepository;

public class ShowtimeRepository implements IShowtimeRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Showtime> getAllShowtimes() {
		EntityManager em = factory.createEntityManager();
		List<Showtime> showtimes = null;
		String hql = "SELECT s FROM Showtime s";
		try {
			TypedQuery<Showtime> query = em.createQuery(hql, Showtime.class);
			showtimes = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return showtimes;
	}

	@Override
	public Showtime getShowtimeById(Long id) {
		EntityManager em = factory.createEntityManager();
		Showtime showtime = null;
		try {
			showtime = em.find(Showtime.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return showtime;
	}

	@Override
	public boolean addShowtime(Showtime showtime) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(showtime);
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
	public boolean updateShowtime(Showtime showtime) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(showtime);
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
	public boolean deleteShowtime(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Showtime showtime = em.find(Showtime.class, id);
			em.getTransaction().begin();
			em.remove(showtime);
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
	public List<Showtime> getShowtimesByDateAndLocale(String fecha, Long local) {
		EntityManager em = factory.createEntityManager();
		List<Showtime> showtimes = null;
		String hql = "SELECT s FROM Showtime s where s.fecha_funcion=?1 and s.SedeFuncion.sede_id=?2";
		try {
			TypedQuery<Showtime> query = em.createQuery(hql, Showtime.class);
			query.setParameter(1, fecha);
			query.setParameter(2, local);

			showtimes = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return showtimes;

	}

}
