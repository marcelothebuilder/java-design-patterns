/**
 * 
 */
package com.github.marcelothebuilder.factorymethod2.fuels.calculator;

import com.github.marcelothebuilder.factorymethod2.fuels.types.Fuel;
import com.github.marcelothebuilder.factorymethod2.loggings.log.Logger;

/**
 * @author Marcelo Paixao Resende
 *
 */
public abstract class FuelCalculator {

	protected Logger logger;

	/**
	 * @param logger
	 */
	public FuelCalculator(Logger logger) {
		super();
		this.logger = logger;
	}

	public double calculate(int amount) {
		Fuel fuel = this.createFuel();
		double total = amount * fuel.getBaseValue();
		logger.log(Double.toString(total));
		return total;
	}

	protected abstract Fuel createFuel();
}
