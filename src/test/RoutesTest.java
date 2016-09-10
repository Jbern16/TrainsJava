package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.graph.Graph;
import org.junit.Before;
import org.junit.Test;
import org.trains.Routes;

public class RoutesTest {
	
	private Routes routes;
	private Graph graph;
	
	@Before 
	public void setup() {
		List<String> stations = new ArrayList<String>();
		stations.add("AB5");
		stations.add("BC4");
		stations.add("CD8");
		stations.add("DC8");
		stations.add("DE6");
		stations.add("AD5");
		stations.add("CE2");
		stations.add("EB3");
		stations.add("AE7"); 
		graph = new Graph(stations);
		routes = new Routes(graph.getGraph());
	}

	@Test
	public void canStringifyRoutes() {
		List<String> nodes = new LinkedList();
		nodes.add("A");
		String stringifiedNode = routes.stringedRoute(nodes);
		assertEquals("A", stringifiedNode);
	}

}
