package com.github.marcelothebuilder.builderpattern.model.builder;

import java.math.BigDecimal;

import com.github.marcelothebuilder.builderpattern.model.Client;
import com.github.marcelothebuilder.builderpattern.model.Order;
import com.github.marcelothebuilder.builderpattern.model.OrderItem;
import com.github.marcelothebuilder.builderpattern.model.builder.restrictions.ClientOrderBuilder;
import com.github.marcelothebuilder.builderpattern.model.builder.restrictions.IdOrderBuilder;
import com.github.marcelothebuilder.builderpattern.model.builder.restrictions.FullOrderBuilder;

public class OrderBuilder implements IdOrderBuilder, ClientOrderBuilder, FullOrderBuilder {
	private Order order;

	private OrderBuilder() {
		this.order = new Order();
	}

	public static IdOrderBuilder getInstance() {
		return new OrderBuilder();
	}

	@Override
	public ClientOrderBuilder withId(Long id) {
		this.order.setId(id);
		return this;
	}

	@Override
	public FullOrderBuilder withClient(String name, boolean vip) {
		Client client = new Client();
		client.setName(name);
		client.setVip(vip);
		this.order.setClient(client);
		return this;
	}

	@Override
	public FullOrderBuilder withItem(String name, String valuePerItem, Integer quantity) {
		OrderItem item = new OrderItem();
		item.setName(name);
		item.setQuantity(quantity);
		item.setValuePerItem(new BigDecimal(valuePerItem));
		this.order.getOrderItems().add(item);
		return this;
	}

	@Override
	public Order build() {
		return this.order;
	}
}
