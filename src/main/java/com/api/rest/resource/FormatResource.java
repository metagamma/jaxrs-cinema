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
import com.api.rest.entity.Format;
import com.api.rest.repository.FormatRepository;
import com.api.rest.repository.interfaces.IFormatRepository;

@Path("formats")

public class FormatResource {

	private IFormatRepository formatRepository;

	/*
	 * Method to get all formats
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllFormats() {
		formatRepository = new FormatRepository();
		List<Format> formats = formatRepository.getAllFormats();
		if (!formats.isEmpty()) {
			return Response.ok(formats).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a format by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFormatById(@PathParam("id") Long id) {
		formatRepository = new FormatRepository();
		Format format = formatRepository.getFormatById(id);
		if (format.getFormato_id() != null) {
			return Response.ok(format).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a format
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFormat(Format format) {
		formatRepository = new FormatRepository();
		boolean bool = formatRepository.addFormat(format);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a format
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateFormat(Format format) {
		formatRepository = new FormatRepository();
		boolean bool = formatRepository.updateFormat(format);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a format by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteFormat(@PathParam("id") Long id) {
		formatRepository = new FormatRepository();
		boolean bool = formatRepository.deleteFormat(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

}
