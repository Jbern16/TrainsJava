package org.graph;
import java.util.HashMap;

public class Graph {
		
		public HashMap<String, HashMap<String, Integer>> graph;
		public HashMap<String, Integer> costs;
		public HashMap<String, Integer> parents;

		public Graph() {
			this.graph = new HashMap<String, HashMap<String,Integer>>();
			this.costs = new HashMap<String, Integer>();
			this.parents = new HashMap<String, Integer>();
	  }  
}
