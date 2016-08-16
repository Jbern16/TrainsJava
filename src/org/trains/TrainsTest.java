package org.trains;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrainsTest {

	@Test
	public void testCanGetDistancesFromDataGraph() {
		Trains train = new Trains();
		int distanceAB = train.data.graph.get("A").get(0).get("B");
		int distanceBC = train.data.graph.get("B").get(0).get("C");
		int distanceCD = train.data.graph.get("C").get(0).get("D");
		int distanceDC = train.data.graph.get("D").get(0).get("C");
		int distanceDE = train.data.graph.get("D").get(1).get("E");
		int distanceAD = train.data.graph.get("A").get(1).get("D");
		int distanceCE = train.data.graph.get("C").get(1).get("E");
		int distanceEB = train.data.graph.get("E").get(0).get("B");
		int distanceAE = train.data.graph.get("A").get(2).get("E");
		assertEquals(distanceAB, 5);
		assertEquals(distanceBC, 4);
		assertEquals(distanceCD, 8);
		assertEquals(distanceDC, 8);
		assertEquals(distanceDE, 6);
		assertEquals(distanceAD, 5);
		assertEquals(distanceCE, 2);
		assertEquals(distanceEB, 3);
		assertEquals(distanceAE, 7);
	}

	

}
