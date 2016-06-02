/**
 * 
 */
package com.github.marcelothebuilder.factorymethod2.loggings.log;

import java.util.Date;

import com.github.marcelothebuilder.factorymethod2.loggings.output.Output;

/**
 * @author Marcelo Paixao Resende
 *
 */
public abstract class Logger {

	protected abstract Output createOutput();

	public void log(String message) {
		Output output = this.createOutput();
		output.print((new Date()).toString());
		output.print(message);
	}
}
