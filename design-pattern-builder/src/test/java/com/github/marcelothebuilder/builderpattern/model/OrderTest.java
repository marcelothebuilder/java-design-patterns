package com.github.marcelothebuilder.builderpattern.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.marcelothebuilder.builderpattern.model.Client;
import com.github.marcelothebuilder.builderpattern.model.Order;
import com.github.marcelothebuilder.builderpattern.model.builder.OrderBuilder;

public class OrderTest {
	
	@Test
	public void shouldCalculateTotalItemValue() {
		OrderItem orderItemOne = new OrderItem();
		orderItemOne.setName("Brazillian Apples");
		orderItemOne.setQuantity(10);
		orderItemOne.setValuePerItem(new BigDecimal("4.00"));
		
		Assert.assertEquals(40.00, orderItemOne.getTotalValue().doubleValue(), 0.0);
	}

	@Test
	public void shouldCalculateValueWithVipClient() {
		Order order = new Order();
		
		Client client = new Client();
		client.setName("Marcos");
		client.setVip(true);
		
		OrderItem orderItemOne = new OrderItem();
		
		// 40
		orderItemOne.setName("Brazillian Apples");
		orderItemOne.setQuantity(10);
		orderItemOne.setValuePerItem(new BigDecimal("4.00"));
		
		
		// 700
		OrderItem orderItemTwo = new OrderItem();
		orderItemTwo.setName("Argentinian Smartphone");
		orderItemTwo.setQuantity(1);
		orderItemTwo.setValuePerItem(new BigDecimal("700.00"));
		
		List<OrderItem> orderItems = Arrays.asList(orderItemOne, orderItemTwo);
		order.setOrderItems(orderItems);
		
		Assert.assertEquals(order.getOrderItems().size(), 2);
		
		order.setClient(client);
		
		// (400+700) * 0.97 = 717,8
		
		BigDecimal totalValue = order.getTotalValue();
		
		Assert.assertEquals(717.8, totalValue.doubleValue(), Double.MIN_NORMAL);
	}
	
	@Test
	public void shouldCalculateValueWithVipUsingBuilder() {
		Order order = OrderBuilder.getInstance()
				.withId(5L)
				.withClient("Marcos", true)
				.withItem("Brazillian Apples", "4.00", 10)
				.withItem("Argentinian Smartphone", "700.00", 1)
				.build();
		
		BigDecimal totalValue = order.getTotalValue();
		Assert.assertEquals(717.8, totalValue.doubleValue(), Double.MIN_NORMAL);
	}

}
