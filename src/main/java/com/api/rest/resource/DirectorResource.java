package com.api.rest.resource;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.api.rest.entity.Director;
import com.api.rest.repository.DirectorRepository;
import com.api.rest.repository.interfaces.IDirectorRepository;

@Path("directors")

public class DirectorResource {

	private IDirectorRepository directorRepository;

	/*
	 * Method to get all directors
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDirectors() {
		directorRepository = new DirectorRepository();
		List<Director> directors = directorRepository.getAllDirectors();
		if (!directors.isEmpty()) {
			return Response.ok(directors).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a director by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getDirectorById(@PathParam("id") Long id) {
		directorRepository = new DirectorRepository();
		Director director = directorRepository.getDirectorById(id);
		if (director.getDirector_id() != null) {
			return Response.ok(director).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a director
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDirector(Director director) {
		directorRepository = new DirectorRepository();
		boolean bool = directorRepository.addDirector(director);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a director
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateDirector(Director director) {
		directorRepository = new DirectorRepository();
		boolean bool = directorRepository.updateDirector(director);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a director by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteDirector(@PathParam("id") Long id) {
		directorRepository = new DirectorRepository();
		boolean bool = directorRepository.deleteDirector(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}
	
}
