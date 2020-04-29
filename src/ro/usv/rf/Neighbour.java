package ro.usv.rf;

import java.util.ArrayList;
import java.util.Arrays;

public class Neighbour implements Comparable<Neighbour> {

	double index; 
	double distance; 
	String className;
	
	public int compareTo(Neighbour compareNeighbor) {
		
	   return Double.compare(this.distance, compareNeighbor.distance);
					
	}	
	 

}
