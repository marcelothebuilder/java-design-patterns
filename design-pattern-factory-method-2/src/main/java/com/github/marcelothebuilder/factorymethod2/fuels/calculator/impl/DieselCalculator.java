/**
 * 
 */
package com.github.marcelothebuilder.factorymethod2.fuels.calculator.impl;

import com.github.marcelothebuilder.factorymethod2.fuels.calculator.FuelCalculator;
import com.github.marcelothebuilder.factorymethod2.fuels.types.Fuel;
import com.github.marcelothebuilder.factorymethod2.fuels.types.impl.Diesel;
import com.github.marcelothebuilder.factorymethod2.loggings.log.Logger;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class DieselCalculator extends FuelCalculator {
	public DieselCalculator(Logger logger) {
		super(logger);
	}

	@Override
	protected Fuel createFuel() {
		return new Diesel();
	}

}
