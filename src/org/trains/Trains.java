package org.trains;

import java.util.ArrayList;
import java.util.HashMap;

import org.graph.Graph;

public class Trains {
	public Graph data;
	  
	 public Trains(ArrayList<String> stations) {
		 this.data = new Graph(stations);
	  }
	  
	protected String routeDistance(String inputCoords) {
		final char coords[] = inputCoords.toCharArray();
		final int lastIndex = coords.length - 1;
		int totalDistance = 0;
		
		for (int i = 0; i < lastIndex; i++) {
			String lookup = Character.toString(coords[i]);
			String endPoint = Character.toString(coords[i + 1]);
			if (checkForIncompatipableRoute(lookup, endPoint)){
				return routeError();
			};
			totalDistance += distance(lookup, endPoint);	
		}
		return String.valueOf(totalDistance);
	}
	
	
//	protected int numberOfTrips(String start, String end, int max ) {
//		return 
//	}
	
	private boolean checkForIncompatipableRoute(String lookup, String endPoint) {
		if (data.graph.get(lookup).get(endPoint) == null){
			return true; 
		} else {
			return false;
		}
	}
	
	private String routeError(){
		return "NO SUCH ROUTE";
	}
	
	private int distance(String lookup, String endPoint) {
		return data.graph.get(lookup).get(endPoint);
	}
}
