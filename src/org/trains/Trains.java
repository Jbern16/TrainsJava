package org.trains;

import java.util.HashMap;

import org.graph.Graph;

public class Trains {
	public Graph data;
	  
	 public Trains() {
		 this.data = new Graph();
		 initializeGraph();
	  }
	  
	private void initializeGraph() {
	      data.graph.put("A", new HashMap<String, Integer>(){{put("B", 5);}});   
	      data.graph.put("B", new HashMap<String, Integer>(){{put("C", 4);}});
	      data.graph.put("C", new HashMap<String, Integer>(){{put("D", 8);}});
	      data.graph.put("D", new HashMap<String, Integer>(){{put("C", 8);}});
	      data.graph.put("D", new HashMap<String, Integer>(){{put("E", 6);}});
	      data.graph.put("A", new HashMap<String, Integer>(){{put("D", 5);}});
	      data.graph.put("C", new HashMap<String, Integer>(){{put("E", 2);}});
	      data.graph.put("E", new HashMap<String, Integer>(){{put("B", 3);}});
	      data.graph.put("A", new HashMap<String, Integer>(){{put("E", 7);}});
	    }

}
