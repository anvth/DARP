package edu.iiitb.darp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DriverProgram {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String text = null;
		//int lineCount = 0;
		int locCount;
		int requestCount;
		int taxiCount;
		int taxiCapacity;
		text = reader.readLine();
		//lineCount++;
		StringTokenizer st = new StringTokenizer(text, " ");
		locCount = Integer.parseInt(st.nextToken());
		taxiCount = Integer.parseInt(st.nextToken());
		taxiCapacity = Integer.parseInt(st.nextToken());
		requestCount = Integer.parseInt(st.nextToken());
		
		//System.out.println(lineCount +":"+ locCount +" "+ taxiCount +" "+ taxiCapacity +" "+ requestCount);
	
		PathMatrix obj = new PathMatrix(locCount);
		
		for(int i=0;i<locCount;i++){
			text = reader.readLine();
			//System.out.println(text);
			st = new StringTokenizer(text," ");
			for(int j=0;j<locCount;j++){
				int temp = Integer.parseInt(st.nextToken());
				//System.out.println("data sent to insert function: "+temp);
				obj.insertLocation(i, j, temp);
			}
		}
		
		obj.printLocations();
	}

}
