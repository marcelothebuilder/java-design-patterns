/**
 * 
 */
package com.github.marcelothebuilder.builderpattern.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class Order {

	private Long id;
	private Client client;
	private List<OrderItem> orderItems = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public BigDecimal getTotalValue() {
		BigDecimal totalValue = BigDecimal.ZERO;

		for (OrderItem orderItem : this.orderItems) {
			totalValue = totalValue.add(orderItem.getTotalValue());
		}

		if (client.isVip()) {
			totalValue = totalValue.multiply(new BigDecimal("0.97"));
		}

		return totalValue;
	}

}
