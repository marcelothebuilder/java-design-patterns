package com.github.marcelothebuilder.builderpattern.model.builder.restrictions;

import com.github.marcelothebuilder.builderpattern.model.Order;

public interface FullOrderBuilder {
	/*
	 * private String name;
	 * private BigDecimal valuePerItem;
	 * private Integer quantity;
	 */
	FullOrderBuilder withItem(String name, String valuePerItem, Integer quantity);
	Order build();
}
