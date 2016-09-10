package org.trains;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.graph.Graph;

public class Routes  {
	private Map<String, Map<String, Integer>> routes;
	
	public Routes(Map<String, Map<String, Integer>> routes) {
		this.routes = routes; 	
	}
	
	public String stringedRoute(List<String> nodes) {
		StringBuilder visitedAsStringBuild = new StringBuilder();
        for (String locale : nodes) {
        	visitedAsStringBuild.append(locale);
        }
        
        return visitedAsStringBuild.toString();
	}
	
	public boolean checkForIncompatipableRoute(String lookup, String endPoint) {
		if (routes.get(lookup).get(endPoint) == null) {
			return true; 
		} else {
			return false;
		}
	}
	
	public String routeError() {
		return "NO SUCH ROUTE";
	}
	
	public int distance(String lookup, String endPoint) {
		return routes.get(lookup).get(endPoint);
	}
	
	public String findLowestCostNode(Map<String, Integer> costs, ArrayList<String> processed) {
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
}

