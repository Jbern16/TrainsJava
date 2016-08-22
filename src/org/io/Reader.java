package org.io;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Reader {
	
	public static ArrayList<String> loadStations(String textPath) {
		ArrayList<String> stations = new ArrayList<String>();
		try {
			Path path = Paths.get(textPath);
			Files.lines(path, StandardCharsets.UTF_8).forEach(station -> {	
				stations.add(station);
			});
		} catch (IOException e) {
			System.err.println("Problem reading the file station_list.txt");
		}
		return stations;
	}
}
