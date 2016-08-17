package org.trains;

import java.util.ArrayList;
import java.util.HashMap;

import org.graph.Graph;

public class Trains {
	public Graph data;
	  
	 public Trains(ArrayList<String> stations) {
		 this.data = new Graph();
		 initializeGraph(stations);
	  }
	  
	private void initializeGraph(ArrayList<String> inputGraph) {
			for (String coord : inputGraph) {
				String start = Character.toString(coord.charAt(0));
				String end = Character.toString(coord.charAt(1));
				int distance = Character.getNumericValue(coord.charAt(2));
				if (data.graph.containsKey(start)) {
					data.graph.get(start).put(end, distance);
				} else {
					data.graph.put(start, new HashMap<String, Integer>(){{put(end, distance);}});
				}
			}
	    }
	
	int distance(String inputCoords) {
		final char coords[] = inputCoords.toCharArray();
		int totalDistance = 0;
		int currentIndex = 0;
		int lastIndex = coords.length - 1;
		
		for (char locale : coords) {
			String lookup = Character.toString(locale);
			if (Character.toString(coords[lastIndex]).equals(lookup)){
				break;
			}
			
			String endPoint = Character.toString(coords[currentIndex + 1]);
//			if (data.graph..get(lookup).get(endPoint).equals(null)) {
//				return "NO SUCH ROUTE";
//			}
			totalDistance += data.graph.get(lookup).get(endPoint);
			currentIndex += 1;
		}
		
		return totalDistance;
	}
	

}
