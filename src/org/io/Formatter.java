package org.io;

public abstract class Formatter {
	
	public static String formatOutput(Object... args){
		StringBuilder formattedData = new StringBuilder(); 
		int outputCounter = 1; 
		for (Object arg : args) {
			formattedData.append("Output #" + String.valueOf(outputCounter) + ": " + String.valueOf(arg) + "\n");
			outputCounter += 1;
		}
		return formattedData.toString();
	}
}
