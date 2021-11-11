package com.api.rest.repository.interfaces;

import java.util.List;
import com.api.rest.entity.SalesOrder;

public interface ISalesOrderRepository {

	List<SalesOrder> getAllSalesOrders();

	SalesOrder getSalesOrderById(Long id);

	boolean addSalesOrder(SalesOrder salesOrder);

	boolean updateSalesOrder(SalesOrder salesOrder);

	boolean deleteSalesOrder(Long id);
	
	List<SalesOrder> listarReservasxCodigo(String cod);

}
