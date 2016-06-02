/**
 * 
 */
package com.github.marcelothebuilder.factorymethod2.loggings.output.impl;

import com.github.marcelothebuilder.factorymethod2.loggings.output.Output;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class OutputError implements Output {
	@Override
	public void print(String message) {
		System.err.println(message);
	}

}
