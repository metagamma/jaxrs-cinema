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
import com.api.rest.entity.Film;
import com.api.rest.repository.FilmRepository;
import com.api.rest.repository.interfaces.IFilmRepository;

@Path("films")

public class FilmResource {

	private IFilmRepository filmRepository;

	/*
	 * Method to get all films
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFilms() {
		filmRepository = new FilmRepository();
		List<Film> films = filmRepository.getAllFilms();
		if (!films.isEmpty()) {
			return Response.ok(films).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a film by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFilmById(@PathParam("id") Long id) {
		filmRepository = new FilmRepository();
		Film film = filmRepository.getFilmById(id);
		if (film.getPelicula_id() != null) {
			return Response.ok(film).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a film
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addFilm(Film film) {
		filmRepository = new FilmRepository();
		boolean bool = filmRepository.addFilm(film);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a film
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateFilm(Film film) {
		filmRepository = new FilmRepository();
		boolean bool = filmRepository.updateFilm(film);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a film by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFilm(@PathParam("id") Long id) {
		filmRepository = new FilmRepository();
		boolean bool = filmRepository.deleteFilm(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

}
