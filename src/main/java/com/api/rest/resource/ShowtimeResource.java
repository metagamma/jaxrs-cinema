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
import com.api.rest.entity.Showtime;
import com.api.rest.repository.ShowtimeRepository;
import com.api.rest.repository.interfaces.IShowtimeRepository;

@Path("showtimes")

public class ShowtimeResource {

	private IShowtimeRepository showtimeRepository;

	/*
	 * Method to get all showtimes
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllShowtimes() {
		showtimeRepository = new ShowtimeRepository();
		List<Showtime> showtimes = showtimeRepository.getAllShowtimes();
		if (!showtimes.isEmpty()) {
			return Response.ok(showtimes).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a showtime by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShowtimeById(@PathParam("id") Long id) {
		showtimeRepository = new ShowtimeRepository();
		Showtime showtime = showtimeRepository.getShowtimeById(id);
		if (showtime.getFuncion_id() != null) {
			return Response.ok(showtime).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a showtime
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addShowtime(Showtime showtime) {
		showtimeRepository = new ShowtimeRepository();
		boolean bool = showtimeRepository.addShowtime(showtime);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a showtime
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateShowtime(Showtime showtime) {
		showtimeRepository = new ShowtimeRepository();
		boolean bool = showtimeRepository.updateShowtime(showtime);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a showtime by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteShowtime(@PathParam("id") Long id) {
		showtimeRepository = new ShowtimeRepository();
		boolean bool = showtimeRepository.deleteShowtime(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	@Path("/{fecha}&{local}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getShowtimesByDateAndLocale(@PathParam("fecha") String fecha, @PathParam("local") Long local) {
		showtimeRepository = new ShowtimeRepository();
		List<Showtime> showtimes = showtimeRepository.getShowtimesByDateAndLocale(fecha, local);
		if (!showtimes.isEmpty()) {
			return Response.ok(showtimes).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}
