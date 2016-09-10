package org.graph;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Graph {
		
		private Map<String, Map<String, Integer>> graph;
		private Map<String, Integer> costs;
		private Map<String, String> parents;

		public Graph(List<String> stations) {
			this.graph = initializeGraph(stations);
			this.costs = new HashMap<String, Integer>();
			this.parents = new HashMap<String, String>();
			
	  }  
		
		public Map<String, Map<String, Integer>> getGraph() {
			return graph;
		}
		
		public Map<String, Integer> getCosts() {
			return costs;
		}
		
		public Map<String, String> getParents() {
			return parents;
		}
		
		private Map<String, Map<String, Integer>> initializeGraph(List<String> inputGraph) {
			graph = new HashMap<String, Map<String, Integer>>();
			

			for (String coord : inputGraph) {
				String start = Character.toString(coord.charAt(0));
				String end = Character.toString(coord.charAt(1));
				int distance = Character.getNumericValue(coord.charAt(2));
				if (graph.containsKey(start)) {
					graph.get(start).put(end, distance);
				} else {
					graph.put(start, new HashMap<String, Integer>(){
						
						private static final long serialVersionUID = 1L;

					{put(end, distance);}});
				}
			}
			return graph;
	    }
		
		public void createCosts(String start, String end) {
			for (String key : adjacentNodes(start)) {
				costs.put(key, graph.get(start).get(key));
			}
			
			costs.put(end, Integer.MAX_VALUE);
		}
		
		public void createParents(String start, String end) {
			for (String node : costs.keySet()){
				parents.put(node, start);
			}
			parents.put(end, "Unknown");
		}
		
		public LinkedList<String> adjacentNodes(String last) {
	        Set<String> adjacent = graph.get(last).keySet();
	        if(adjacent == null) {
	            return new LinkedList<String>();
	        }
	        return new LinkedList<String>(adjacent);
	    }

}
