package com.api.rest.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.api.rest.entity.Location;
import com.api.rest.repository.interfaces.ILocationRepository;

public class LocationRepository implements ILocationRepository {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("PE");

	@Override
	public List<Location> getAllLocations() {
		EntityManager em = factory.createEntityManager();
		List<Location> locations = null;
		String hql = "SELECT l FROM Location l";
		try {
			TypedQuery<Location> query = em.createQuery(hql, Location.class);
			locations = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return locations;
	}

	@Override
	public Location getLocationById(Long id) {
		EntityManager em = factory.createEntityManager();
		Location location = null;
		try {
			location = em.find(Location.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
			factory.close();
		}
		return location;
	}

	@Override
	public boolean addLocation(Location location) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.persist(location);
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
	public boolean updateLocation(Location location) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			em.getTransaction().begin();
			em.merge(location);
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
	public boolean deleteLocation(Long id) {
		EntityManager em = factory.createEntityManager();
		boolean bool = true;
		try {
			Location location = em.find(Location.class, id);
			em.getTransaction().begin();
			em.remove(location);
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
