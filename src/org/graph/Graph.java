package org.graph;
import java.util.ArrayList;
import java.util.HashMap;

public class Graph {
		
		public HashMap<String, HashMap<String, Integer>> graph;
		public HashMap<String, Integer> costs;
		public HashMap<String, Integer> parents;

		public Graph(ArrayList<String> stations) {
			this.graph = initializeGraph(stations);
			this.costs = new HashMap<String, Integer>();
			this.parents = new HashMap<String, Integer>();
			
	  }  
		
		private HashMap<String, HashMap<String, Integer>> initializeGraph(ArrayList<String> inputGraph) {
			graph = new HashMap<String, HashMap<String, Integer>>();
			
			for (String coord : inputGraph) {
				String start = Character.toString(coord.charAt(0));
				String end = Character.toString(coord.charAt(1));
				int distance = Character.getNumericValue(coord.charAt(2));
				if (graph.containsKey(start)) {
					graph.get(start).put(end, distance);
				} else {
					graph.put(start, new HashMap<String, Integer>(){{put(end, distance);}});
				}
			}
			return graph;
	    }
}
