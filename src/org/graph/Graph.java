package org.graph;
import java.util.HashMap;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

public class Graph {
		
		public ListMultimap<String, HashMap<String, Integer>> graph;
		public HashMap<String, Integer> costs;
		public HashMap<String, Integer> parents;

		public Graph() {
			this.graph = ArrayListMultimap.create();
			this.costs = new HashMap<String, Integer>();
			this.parents = new HashMap<String, Integer>();
	  }  
}
