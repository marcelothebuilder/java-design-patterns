package com.github.marcelothebuilder.factorymethod2.fuels.types.impl;

import com.github.marcelothebuilder.factorymethod2.fuels.types.Fuel;

public class Gasoline implements Fuel {
	@Override
	public double getBaseValue() {
		return 2.4;
	}
}
