/**
 * 
 */
package com.github.marcelothebuilder.factorymethod2.loggings.log.impl;

import com.github.marcelothebuilder.factorymethod2.loggings.log.Logger;
import com.github.marcelothebuilder.factorymethod2.loggings.output.Output;
import com.github.marcelothebuilder.factorymethod2.loggings.output.impl.OutputConsole;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class LoggerConsole extends Logger {
	@Override
	protected Output createOutput() {
		return new OutputConsole();
	}

}
