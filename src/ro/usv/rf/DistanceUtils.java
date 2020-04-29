package ro.usv.rf;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DistanceUtils {
	
	
	protected static String calculateKNN(int k, double[] distance, String[][] learningSet)
	{
			Neighbour[] neighbors = new Neighbour[learningSet.length];
			
			for(int i=0;i<learningSet.length;i++)
			{
				neighbors[i] = new Neighbour();
				neighbors[i].index = i;
				neighbors[i].className = learningSet[i][4];
				neighbors[i].distance = distance[i];
			}
			
			Arrays.sort(neighbors);
			ArrayList<Integer> frequencyNumber = new ArrayList<Integer>();
			ArrayList<String> frequencyName = new ArrayList<String>();
			frequencyNumber.add(1);
			frequencyName.add(neighbors[0].className);
			//System.out.println("0 : " + neighbors[0].distance + " & " + neighbors[0].className);
			
			for(int i=1;i<k;i++)
			{
				//System.out.println(i + " : " + neighbors[i].distance + " & " + neighbors[i].className);

				int pos = frequencyName.indexOf(neighbors[i].className);
				if(pos == -1)
				{
					frequencyNumber.add(1);
					frequencyName.add(neighbors[i].className);
				}
				else
				{
					int value = frequencyNumber.get(pos);
					frequencyNumber.set(pos, value+1);
				}
			}
			
			int index = 0;
			int max = Integer.MIN_VALUE;
			
			for(int i=0;i<frequencyNumber.size();i++)
			{
				if(frequencyNumber.get(i) > max)
				{
					max = frequencyNumber.get(i);
					index = i;
				}
			}
			
			return frequencyName.get(index);
	}
	
	
	public static double calculateDistanceEuclidianGeneralizedString(String[] pattern1, String[] pattern2)
	{
		double sum = 0D;
		for(int i=0;i<4;i++)
		{
			sum+=(Math.pow(Double.valueOf(pattern1[i])-Double.valueOf(pattern2[i]),2));
		}
		return Math.sqrt(sum);
		//return Math.sqrt(Math.pow(pattern1[0]-pattern2[0],2) + Math.pow(pattern1[1]- pattern2[1], 2));
	}
	
	
	
	
	
}
