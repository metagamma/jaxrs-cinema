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
import com.api.rest.entity.SalesOrder;
import com.api.rest.repository.SalesOrderRepository;
import com.api.rest.repository.interfaces.ISalesOrderRepository;

@Path("salesorders")

public class SalesOrdenResource {

	private ISalesOrderRepository salesOrderRepository;

	/*
	 * Method to get all sales orders
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllSalesOrders() {
		salesOrderRepository = new SalesOrderRepository();
		List<SalesOrder> salesorders = salesOrderRepository.getAllSalesOrders();
		if (!salesorders.isEmpty()) {
			return Response.ok(salesorders).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to get a sales order by id
	 */

	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSalesOrderById(@PathParam("id") Long id) {
		salesOrderRepository = new SalesOrderRepository();
		SalesOrder salesorder = salesOrderRepository.getSalesOrderById(id);
		if (salesorder.getOrden_venta_id() != null) {
			return Response.ok(salesorder).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	/**********************************************************/
	@Path("/{cod}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarReservasxCodigo(@PathParam("cod") String cod) {
		salesOrderRepository = new SalesOrderRepository();
		List<SalesOrder> salesorder = salesOrderRepository.listarReservasxCodigo(cod);
		if (!salesorder.isEmpty()) {
			return Response.ok(salesorder).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	/*
	 * Method to add a sales order
	 */

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSalesOrder(SalesOrder salesOrder) {
		salesOrderRepository = new SalesOrderRepository();
		boolean bool = salesOrderRepository.addSalesOrder(salesOrder);
		if (bool) {
			return Response.ok().status(Response.Status.CREATED).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to update a sales order
	 */

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateSalesOrder(SalesOrder salesOrder) {
		salesOrderRepository = new SalesOrderRepository();
		boolean bool = salesOrderRepository.updateSalesOrder(salesOrder);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

	/*
	 * Method to delete a sales order by id
	 */

	@Path("/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteSalesOrder(@PathParam("id") Long id) {
		salesOrderRepository = new SalesOrderRepository();
		boolean bool = salesOrderRepository.deleteSalesOrder(id);
		if (bool) {
			return Response.ok().status(Response.Status.NO_CONTENT).build();
		} else {
			return Response.notModified().build();
		}
	}

}
