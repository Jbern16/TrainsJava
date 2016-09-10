package org.main;

import java.util.ArrayList;

import org.graph.Graph;
import org.io.Formatter;
import org.io.Reader;
import org.io.Writer;
import org.trains.Routes;
import org.trains.Trains;

public class Main {
	
	// this is the main function that will be calling the appropriate functions to write the designated outputs to a new text file called station_ouput.txt
	// Functions 
	// routeDistance(String) =  find distance from a specific route as a string
	// numberOfTripsMax(String start of route, String end of route, Integer maximum number of trips) = find number of trips within a max number of stops
	// numberOfTripsExactStops(String start of route, String end of route, Integer exact number of trips) = find number of trips with an exact number of stops
	// shortestRoute(String start of route, String end of route) = find shortest route between two stations
	// amountOfTripsWithinDistance(String start of route, String end of route, Integer maximum distance allowed) = find all routes from start to end under a certain distance apart
	
	public static void main(String[] args) {
		ArrayList<String> stations = Reader.loadStations("station_list.txt");
		Graph graph = new Graph(stations);
		Routes routes = new Routes(graph.getGraph());
		Trains train = new Trains(graph, routes);
		
		// to find distance, please insert or edit the route argument for routeDistance below as a String
		String output1 = train.routeDistance("ABC");
		String output2 = train.routeDistance("AD");
		String output3 = train.routeDistance("ADC");
		String output4 = train.routeDistance("AEBCD");
		String output5 = train.routeDistance("AED");
		
		// to find number of trips within maximum amount of stops, please put your start first, then end, then max number of trips
		int output6    = train.numberOfTripsMax("C", "C", 3);
		
		// to find number of trips with an exact amount of stops, please put your start first, then end, then exact number of trips
		int output7    = train.numberOfTripsExactStops("A", "C", 4);
		
		// to find shortest route between two points, please provide your start, then end
		int output8    = train.shortestRoute("A", "C");
		int output9    = train.shortestRoute("B", "B");
		
		// to find amount of trips within a specific distance, please provide a start, then end, then a maximum distance
		int output10   = train.amountOfTripsWithinDistance("C", "C", 30);
		
		// sends all outputs off to formatter to be formatted as one string
		String formmatedData =  Formatter.formatOutput(output1, output2, output3, output4, output5, output6, output7, output8, output9, output10);
		// writes formatted data to station_output.txt in project directory.
		Writer.writeOutputs(formmatedData);
	}

}
