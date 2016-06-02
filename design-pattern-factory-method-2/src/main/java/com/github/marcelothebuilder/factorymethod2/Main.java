package com.github.marcelothebuilder.factorymethod2;

import com.github.marcelothebuilder.factorymethod2.fuels.calculator.FuelCalculator;
import com.github.marcelothebuilder.factorymethod2.fuels.calculator.impl.DieselCalculator;
import com.github.marcelothebuilder.factorymethod2.fuels.calculator.impl.GasolineCalculator;
import com.github.marcelothebuilder.factorymethod2.loggings.log.Logger;
import com.github.marcelothebuilder.factorymethod2.loggings.log.impl.LoggerConsole;
import com.github.marcelothebuilder.factorymethod2.loggings.log.impl.LoggerError;

public class Main {
	public static void main(String[] args) {
		{
			Logger logger = new LoggerConsole();
			FuelCalculator calc = new GasolineCalculator(logger);
			calc.calculate(3);
		}

		{
			Logger logger = new LoggerError();
			FuelCalculator calc = new DieselCalculator(logger);
			calc.calculate(1);
		}
	}

}
