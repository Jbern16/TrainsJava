package org.trains;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import org.graph.Graph;


public class Trains {
	private Graph data;
	private int trips;
	private Routes routes;

	 public Trains(Graph graph, Routes routes) {
		 this.data = graph;
		 this.trips = 0;
		 this.routes = routes;
	  }
	  
	
	public Graph getGraph() {
		return data;
	}
	
	public String routeDistance(String inputCoords) {
		final char coords[] = inputCoords.toCharArray();
		final int lastIndex = coords.length - 1;
		int totalDistance = 0;
		
		for (int i = 0; i < lastIndex; i++) {
			String lookup = Character.toString(coords[i]);
			String endPoint = Character.toString(coords[i + 1]);
			if (routes.checkForIncompatipableRoute(lookup, endPoint)){
				return routes.routeError();
			};
			totalDistance += routes.distance(lookup, endPoint);	
		}
		return String.valueOf(totalDistance);
	}
	
	
	public int numberOfTripsMax(String start, String end, int max ) {
		 int totalTrips = 0;
		 Queue<String> queue = new ArrayDeque<String>();
		 Queue<String> parentQueue = new ArrayDeque<String>();
		 String currentParent = start;
		 queue.addAll(data.adjacentNodes(start));
		 int currentDepth = 0;
		 while (currentDepth < max) {
			  String neighbor = queue.remove();
			  parentQueue.add(neighbor);
			  if (neighbor.equals(end)) {
				  totalTrips += 1;
			  } else{
				  queue.addAll(data.adjacentNodes(neighbor));  
			  } 
			  if (data.getGraph().get(currentParent).get(neighbor) == null) {
				  currentParent = parentQueue.remove();
				  currentDepth += 1;
			  }
		 }
		 return totalTrips;
	}

	public int numberOfTripsExactStops(String start, String end, int exact ) {
		LinkedList<String> visited = new LinkedList<String>();
		trips = 0;
        visited.add(start);
        numberOfTripsExactStops(end, visited, exact);
        return trips;
        
	}
	
	private void numberOfTripsExactStops(String end, LinkedList<String> visited, int exact) {
		LinkedList<String> nodes = data.adjacentNodes(visited.getLast());
			for (String node : nodes) {
				if (visited.size() > exact) {
					continue;
				}
				if (node.equals(end)) {
					if (visited.size() == (exact)) {
						trips += 1;
					}
					visited.add(node);
					visited.removeLast();
					break;
		         }
		    }
		    for (String node : nodes) {
		    	if (visited.contains(node) && data.getGraph().get(node).get(end) == null) {
		            continue;
		        }
		    	visited.addLast(node);
		        numberOfTripsExactStops(end, visited, exact);
		        visited.removeLast();
		    }
	}
		
	public int amountOfTripsWithinDistance(String start, String end, int maxDistance) {
		LinkedList<String> visited = new LinkedList<String>();
		trips = 0;
        visited.add(start);
        amountOfTripsWithinDistance(end, visited, maxDistance);
        return trips;
	}
				        
	private void amountOfTripsWithinDistance(String end, LinkedList<String> visited, int maxDistance) {
       LinkedList<String> nodes = data.adjacentNodes(visited.getLast());
       boolean maxPathReached = false;
		for (String node : nodes) {
			if (node.equals(end)) {
				visited.add(node);
				int routedDistance =  Integer.valueOf(routeDistance(routes.stringedRoute(visited)));
				if (routedDistance < maxDistance) {
					trips += 1;
				} else {
					maxPathReached = true;
				}
				
				visited.removeLast();
				break;
	         }
	    }
	    for (String node : nodes) {
	    	if (maxPathReached) {
	            continue;
	        }
	    	visited.addLast(node);
	        amountOfTripsWithinDistance(end, visited, maxDistance);
	        visited.removeLast();
	    }
       
   }
 
	public int shortestRoute(String start, String end) {
		data.createCosts(start, end);
		data.createParents(start, end);
		
		ArrayList<String> processed = new ArrayList<String>();
		String node = routes.findLowestCostNode(data.getCosts(), processed);
		
		while (node != null) {
			int cost = data.getCosts().get(node);
			Map<String, Integer>neighbors = data.getGraph().get(node);
			for (String key : neighbors.keySet()) {
				int newCost = cost + neighbors.get(key);
			
				if( data.getCosts().get(key) > newCost) {
					data.getCosts().put(key, newCost);
					data.getParents().put(key, node);
				}
			}
	
			processed.add(node);
			node = routes.findLowestCostNode(data.getCosts(), processed);
		}
		
		return data.getCosts().get(end);
	}
}
	

