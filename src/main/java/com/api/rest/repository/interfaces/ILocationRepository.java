package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.Location;

public interface ILocationRepository {

	List<Location> getAllLocations();

	Location getLocationById(Long id);

	boolean addLocation(Location location);

	boolean updateLocation(Location location);

	boolean deleteLocation(Long id);

}
