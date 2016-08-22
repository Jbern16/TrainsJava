package org.trains;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class TrainsHelper {
	
	protected static String stringedRoute(LinkedList<String> route) {
		StringBuilder visitedAsStringBuild = new StringBuilder();
        for (String locale : route) {
        	visitedAsStringBuild.append(locale);
        }
        
        return visitedAsStringBuild.toString();
	}
	
	protected static boolean checkForIncompatipableRoute(String lookup, String endPoint, HashMap<String, HashMap<String, Integer>> graph) {
		if (graph.get(lookup).get(endPoint) == null){
			return true; 
		} else {
			return false;
		}
	}
	
	protected static String routeError(){
		return "NO SUCH ROUTE";
	}
	
	protected static int distance(String lookup, String endPoint, HashMap<String, HashMap<String, Integer>> graph) {
		return graph.get(lookup).get(endPoint);
	}
	
	protected static String findLowestCostNode(HashMap<String, Integer> costs, ArrayList<String> processed) {
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

