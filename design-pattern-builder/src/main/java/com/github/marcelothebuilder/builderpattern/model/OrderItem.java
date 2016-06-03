/**
 * 
 */
package com.github.marcelothebuilder.builderpattern.model;

import java.math.BigDecimal;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class OrderItem {
	private String name;
	private BigDecimal valuePerItem;
	private Integer quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getValuePerItem() {
		return valuePerItem;
	}
	public void setValuePerItem(BigDecimal valuePerItem) {
		this.valuePerItem = valuePerItem;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalValue() {
		BigDecimal bigQuantity = new BigDecimal(this.quantity);
		return this.valuePerItem.multiply(bigQuantity);
	}
}
