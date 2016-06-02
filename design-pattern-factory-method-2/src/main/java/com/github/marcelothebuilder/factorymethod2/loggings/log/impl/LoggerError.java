/**
 * 
 */
package com.github.marcelothebuilder.factorymethod2.loggings.log.impl;

import com.github.marcelothebuilder.factorymethod2.loggings.log.Logger;
import com.github.marcelothebuilder.factorymethod2.loggings.output.Output;
import com.github.marcelothebuilder.factorymethod2.loggings.output.impl.OutputError;

/**
 * @author Marcelo Paixao Resende
 *
 */
public class LoggerError extends Logger {
	@Override
	protected Output createOutput() {
		return new OutputError();
	}

}
