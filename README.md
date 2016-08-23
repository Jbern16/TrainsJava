## Trains - Java

```
Problem:  The local commuter railroad services a number of towns in Kiwiland.  Because of monetary concerns, all of the tracks are 'one-way.'  That is, a route from Kaitaia to Invercargill does not imply the existence of a route from Invercargill to Kaitaia.  In fact, even if both of these routes do happen to exist, they are distinct and are not necessarily the same distance!
 
The purpose of this problem is to help the railroad provide its customers with information about the routes.  In particular, you will compute the distance along a certain route, the number of different routes between two towns, and the shortest route between two towns.
  
1. The distance of the route A-B-C.
2. The distance of the route A-D.
3. The distance of the route A-D-C.
4. The distance of the route A-E-B-C-D.
5. The distance of the route A-E-D.
6. The number of trips starting at C and ending at C with a maximum of 3 stops.  In the sample data below, there are two such trips: C-D-C (2 stops). and C-E-B-C (3 stops).
7. The number of trips starting at A and ending at C with exactly 4 stops.  In the sample data below, there are three such trips: A to C (via B,C,D); A to C (via D,C,D); and A to C (via D,E,B).
8. The length of the shortest route (in terms of distance to travel) from A to C.
9. The length of the shortest route (in terms of distance to travel) from B to B.
10. The number of different routes from C to C with a distance of less than 30.  In the sample data, the trips are: CDC, CEBC, CEBCDC, CDCEBC, CDEBC, CEBCEBC, CEBCEBCEBC.

```


### To Build and Run:

By running this program, it will take input from ``station_list.txt``, create the appropriate graph and write the answers 
to the above questions to ``stations_output.txt``.

1) Build:

* Open Project In Eclipse

* Click `project` on toolbar - make sure build automatically is de-selected

* Click-on `clean..`

* Select `clean projects selected below`

* Select TrainsJava from list of projects 

* Deselect `start build immediately`

* Click OK

* Select `project` from tool bar and click `build project`

2) Run:

* With the build complete, in the package explorer,  right click on the `TrainsJava` and click `Run As -> Java Application`.

* Select `Main`

* This should create or edit `station_output.txt`

* If first time running, refresh Workspace by right clicking `TrainsJava` and selecting `Refresh` - this will update your pakage explorer with created text file.

### To Run Tests: 

* Tests are using the data asked from the problem 

* With the project open in Eclipse, in the package explorer, right click on `TrainsJava` and click `Run As --> JUnit Test`

* Select `RunAllTests` config

* This will run the the `TrainsTest.java` and `GraphTest.java`

### To Edit Stations:

* Open `station_list.txt` in the root of the folder

* On each line, provide a route and distance. For example "AB5" would represent a route from A to B with a distance of 5

### To Edit Outputs: 

* Open `Main.java` in `src/main`

* The following hooks can be used to to find routing data 

 ```
  routeDistance(String) 
   * finds distance from a specific route as a string
	
  numberOfTripsMax(String start of route, String end of route, Integer maximum number of trips)
   * find number of trips within a max number of stops using a breadth first search
	
  numberOfTripsExactStops(String start of route, String end of route, Integer exact number of trips) 
   * find number of trips with an exact number of stops using a depth first search
	
  shortestRoute(String start of route, String end of route) 
   * find shortest route between two stations using Dijkstra's Algorirth
	
  amountOfTripsWithinDistance(String start of route, String end of route, Integer maximum distance allowed) 
   * find all routes from start to end under a certain distance apart using a depth first search. 

   ```
