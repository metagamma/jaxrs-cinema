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
import com.api.rest.entity.Rating;
import com.api.rest.repository.RatingRepository;
import com.api.rest.repository.interfaces.IRatingRepository;

@Path("ratings")

public class RatingResource {

	private IRatingRepository ratingRepository;

	/*
	 * Method to get all ratings
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRatings() {
		ratingRepository = new RatingRepository();
		List<Rating> ratings = ratingRepository.getAllRatings();
		if (!ratings.isEmpty()) {
			return Response.ok(ratings).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a rating by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getRatingById(@PathParam("id") Long id) {
		ratingRepository = new RatingRepository();
		Rating rating = ratingRepository.getRatingById(id);
		if (rating.getClasificacion_id() != null) {
			return Response.ok(rating).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a rating
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRating(Rating rating) {
		ratingRepository = new RatingRepository();
		boolean bool = ratingRepository.addRating(rating);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a rating
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRating(Rating rating) {
		ratingRepository = new RatingRepository();
		boolean bool = ratingRepository.updateRating(rating);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a rating by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteRating(@PathParam("id") Long id) {
		ratingRepository = new RatingRepository();
		boolean bool = ratingRepository.deleteRating(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

}
