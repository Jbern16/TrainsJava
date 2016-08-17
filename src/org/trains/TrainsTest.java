package org.trains;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TrainsTest {
//	AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
	
	
	
	
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
	public void testCanGetDistancesFromDataGraph() {
		ArrayList<String> stations = createStationsArray(); 
		Trains train = new Trains(stations);
		int distanceAB = train.data.graph.get("A").get("B");
		int distanceBC = train.data.graph.get("B").get("C");
		int distanceCD = train.data.graph.get("C").get("D");
		int distanceDC = train.data.graph.get("D").get("C");
		int distanceDE = train.data.graph.get("D").get("E");
		int distanceAD = train.data.graph.get("A").get("D");
		int distanceCE = train.data.graph.get("C").get("E");
		int distanceEB = train.data.graph.get("E").get("B");
		int distanceAE = train.data.graph.get("A").get("E");
//		
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
	
	@Test
	public void testCanSumDistancesFromPath() {
		ArrayList<String> stations = createStationsArray(); 
		Trains train = new Trains(stations);
		int sumABC = train.distance("ABC");
		int sumAD = train.distance("AD");
		int sumADC = train.distance("ADC");
		int sumAEBCD = train.distance("AEBCD");
//		int sumAED = train.distance("AED");
		assertEquals(9, sumABC);
		assertEquals(5, sumAD);
		assertEquals(13, sumADC);
		assertEquals(22, sumAEBCD);
//		assertEquals("NO SUCH ROUTE", sumAED);
	}
}
