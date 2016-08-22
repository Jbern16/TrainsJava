package org.graph;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;


public class GraphTest {
	
	public ArrayList<String> createStationsArray(){
		ArrayList<String> stations = new ArrayList<String>();
		stations.add("AB5");
		stations.add("BC4");
		stations.add("CD8");
		stations.add("DC8");
		stations.add("DE6");
		stations.add("AD5");
		stations.add("CE2");
		stations.add("EB3");
		stations.add("AE7");
		
		return stations;
	}

	@Test
	public void testCanGetAdjacentNodes() {
		ArrayList<String> stations = createStationsArray(); 
		Graph graph = new Graph(stations);
		LinkedList<String> neighbors = graph.adjacentNodes("A");
		LinkedList<String> expected = new LinkedList<String>();
		expected.add("B");
		expected.add("D");
		expected.add("E");
		
		assertEquals(neighbors, expected);
		
	}
	
	@Test
	public void testCanInitializeParents() {
		ArrayList<String> stations = createStationsArray(); 
		Graph graph = new Graph(stations);
		graph.createParents("A", "C");
		
		assertEquals("Unknown", graph.parents.get("C"));
	}
	
	@Test
	public void testCanInitializeCosts() {
		ArrayList<String> stations = createStationsArray(); 
		Graph graph = new Graph(stations);
		graph.createCosts("A", "C");
		int costC = graph.costs.get("C");
		int costB = graph.costs.get("B");
		int costD = graph.costs.get("D");
		int costE = graph.costs.get("E");
		assertEquals(costC, Integer.MAX_VALUE);
	
		assertEquals(costB, 5);
		assertEquals(costD, 5);
		assertEquals(costE, 7);
	}


}
