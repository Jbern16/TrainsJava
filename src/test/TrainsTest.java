package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Test;
import org.trains.Trains;

public class TrainsTest {

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
		String sumABC = train.routeDistance("ABC");
		String sumAD = train.routeDistance("AD");
		String sumADC = train.routeDistance("ADC");
		String sumAEBCD = train.routeDistance("AEBCD");
		String sumAED = train.routeDistance("AED");
		assertEquals("9", sumABC);
		assertEquals("5", sumAD);
		assertEquals("13", sumADC);
		assertEquals("22", sumAEBCD);
		assertEquals("NO SUCH ROUTE", sumAED);
	}
	
	@Test
	public void testCanFindNumberOfRoutesFromStartToEnd(){
		ArrayList<String> stations = createStationsArray(); 
		Trains train = new Trains(stations);
		int tripsCC = train.numberOfTripsMax("C", "C", 3);
		int tripsAC = train.numberOfTripsExactStops("A", "C", 4);
		assertEquals(tripsCC, 2);
		assertEquals(tripsAC, 3);
	}
	
	@Test
	public void testCanFindShortestRoute(){
		ArrayList<String> stations = createStationsArray(); 
		Trains train = new Trains(stations);
		int tripsAC = train.shortestRoute("A", "C");
		int tripsBB = train.shortestRoute("B", "B");
		assertEquals(tripsAC, 9);
		assertEquals(tripsBB, 9);
	}
	
	@Test
	public void testCanFindAmountOfRoutesUnderCertainDistance(){
		ArrayList<String> stations = createStationsArray(); 
		Trains train = new Trains(stations);
		int tripsCC = train.amountOfTripsWithinDistance("C", "C", 30);
		assertEquals(tripsCC, 7);
	}
}
