package org.trains;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.graph.Graph;

public class Trains {
	public Graph data;
	public int trips;

	  
	 public Trains(ArrayList<String> stations) {
		 this.data = new Graph(stations);
		 this.trips = 0;
		
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
	
	
	protected int numberOfTripsMax(String start, String end, int max ) {
		 int totalTrips = 0;
		 Queue<String> queue = new ArrayDeque<String>();
		 Queue<String> parentQueue = new ArrayDeque<String>();
		 String currentParent = start;
		 queue.addAll(data.graph.get(start).keySet());
		 int currentDepth = 0;
		 while (currentDepth < max) {
			  String neighbor = queue.remove();
			  parentQueue.add(neighbor);
			  if (neighbor.equals(end)) {
				  totalTrips += 1;
			  }  else {
				  queue.addAll(data.graph.get(neighbor).keySet());				  	  
			  	}
			  
			  if (data.graph.get(currentParent).get(neighbor) == null) {
				  currentParent = parentQueue.remove();
				  currentDepth += 1;
			  }
		 }
		 return totalTrips;
	}

	
	//this is giving me problems --- need to find better solution --- dfs??
	protected int numberOfTripsExactStops(String start, String end, int exact ) {
		LinkedList<String> visited = new LinkedList();
        visited.add(start);
        numberOfTripsExactStops(start, end, visited, exact);
        return this.trips;
	}
	
	private void numberOfTripsExactStops(String start, String end, LinkedList<String> visited, int exact) {
		LinkedList<String> nodes = data.adjacentNodes(visited.getLast());
			for (String node : nodes) {
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
		    	if (visited.contains(node) && data.graph.get(node).get(end) == null) {
		            continue;
		        }
		    	visited.addLast(node);
		        numberOfTripsExactStops(start, end, visited, exact);
		        visited.removeLast();
		      }
	}
		
	

	protected int amountOfTripsWithinDistance(String start, String end, int maxDistance) {
		LinkedList<String> visited = new LinkedList();
        visited.add(start);
        amountOfTripsWithinDistance(start, end, visited, maxDistance);
        return this.trips;
	}
				        
   private void amountOfTripsWithinDistance(String start, String end, LinkedList<String> visited, int maxDistance) {
       LinkedList<String> nodes = data.adjacentNodes(visited.getLast());
       
//	            StringBuilder visitedAsStringBuild = new StringBuilder();
//	            for (String locale : visited) {
//	            	visitedAsStringBuild.append(locale);
//	            }
//	            final String visitedAsString = visitedAsStringBuild.toString();
//	  
//	            int routedDistance = Integer.valueOf(routeDistance(visitedAsString));
//	            
//	            if (routedDistance >= maxDistance) {
//	                continue;
//	            }
	    
	 
   }
 
	protected int shortestRoute(String start, String end) {
		data.createCosts(start, end);
		data.createParents(start, end);
		
		ArrayList<String> processed = new ArrayList<String>();
		String node = findLowestCostNode(data.costs, processed);
		
		while (node != null) {
			int cost = data.costs.get(node);
			HashMap<String, Integer>neighbors = data.graph.get(node);
			for (String key : neighbors.keySet()) {
				int newCost = cost + neighbors.get(key);
			
				
				if( data.costs.get(key) > newCost) {
					data.costs.put(key, newCost);
					data.parents.put(key, node);
				}
			}
	
			processed.add(node);
			node = findLowestCostNode(data.costs, processed);
		}
		
		return data.costs.get(end);
	}
	
	
	private String findLowestCostNode(HashMap<String, Integer> costs, ArrayList<String> processed) {
		Integer lowestCost = Integer.MAX_VALUE;
		String lowestCostNode = null;
		for (String key : costs.keySet() ) {
			if ((costs.get(key) < lowestCost) && !processed.contains(key)) {
				lowestCost = costs.get(key);
				lowestCostNode = key;
			}	
		}
		return lowestCostNode;
	}

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
