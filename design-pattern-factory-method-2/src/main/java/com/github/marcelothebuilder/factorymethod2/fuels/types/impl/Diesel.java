/**
 * 
 */
package com.github.marcelothebuilder.factorymethod2.fuels.types.impl;

import com.github.marcelothebuilder.factorymethod2.fuels.types.Fuel;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class Diesel implements Fuel {
	@Override
	public double getBaseValue() {
		return 6.7;
	}

}
