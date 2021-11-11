package com.api.rest.resource;

import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.api.rest.entity.Location;
import com.api.rest.repository.LocationRepository;
import com.api.rest.repository.interfaces.ILocationRepository;

@Path("locations")

public class LocationResource {

	private ILocationRepository locationRepository;

	/*
	 * Method to get all locations
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllLocations() {
		locationRepository = new LocationRepository();
		List<Location> locations = locationRepository.getAllLocations();
		if (!locations.isEmpty()) {
			return Response.ok(locations).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a location by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocationById(@PathParam("id") Long id) {
		locationRepository = new LocationRepository();
		Location location = locationRepository.getLocationById(id);
		if (location.getSede_id() != null) {
			return Response.ok(location).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a location
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addLocation(Location location) {
		locationRepository = new LocationRepository();
		boolean bool = locationRepository.addLocation(location);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a location
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateLocation(Location location) {
		locationRepository = new LocationRepository();
		boolean bool = locationRepository.updateLocation(location);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a location by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteLocation(@PathParam("id") Long id) {
		locationRepository = new LocationRepository();
		boolean bool = locationRepository.deleteLocation(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

}
