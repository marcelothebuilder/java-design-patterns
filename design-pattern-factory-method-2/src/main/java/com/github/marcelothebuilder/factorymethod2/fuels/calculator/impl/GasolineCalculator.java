/**
 * 
 */
package com.github.marcelothebuilder.factorymethod2.fuels.calculator.impl;

import com.github.marcelothebuilder.factorymethod2.fuels.calculator.FuelCalculator;
import com.github.marcelothebuilder.factorymethod2.fuels.types.Fuel;
import com.github.marcelothebuilder.factorymethod2.fuels.types.impl.Gasoline;
import com.github.marcelothebuilder.factorymethod2.loggings.log.Logger;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class GasolineCalculator extends FuelCalculator {
	public GasolineCalculator(Logger logger) {
		super(logger);
	}

	@Override
	protected Fuel createFuel() {
		return new Gasoline();
	}

}
