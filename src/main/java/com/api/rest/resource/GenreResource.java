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
import com.api.rest.entity.Genre;
import com.api.rest.repository.GenreRepository;
import com.api.rest.repository.interfaces.IGenreRepository;

@Path("genres")

public class GenreResource {

	private IGenreRepository genreRepository;

	/*
	 * Method to get all genres
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllGenres() {
		genreRepository = new GenreRepository();
		List<Genre> genres = genreRepository.getAllGenres();
		if (!genres.isEmpty()) {
			return Response.ok(genres).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a genre by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getGenreById(@PathParam("id") Long id) {
		genreRepository = new GenreRepository();
		Genre genre = genreRepository.getGenreById(id);
		if (genre.getGenero_id() != null) {
			return Response.ok(genre).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a genre
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addGenre(Genre genre) {
		genreRepository = new GenreRepository();
		boolean bool = genreRepository.addGenre(genre);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a genre
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateGenre(Genre genre) {
		genreRepository = new GenreRepository();
		boolean bool = genreRepository.updateGenre(genre);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a genre by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteGenre(@PathParam("id") Long id) {
		genreRepository = new GenreRepository();
		boolean bool = genreRepository.deleteGenre(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

}
