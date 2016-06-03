/**
 * 
 */
package com.github.marcelothebuilder.builderpattern.model;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class Client {
	private String name;
	private boolean vip;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isVip() {
		return vip;
	}
	public void setVip(boolean vip) {
		this.vip = vip;
	}
}
