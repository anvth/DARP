package edu.iiitb.darp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DriverProgram {
	 

	public static List<Taxi> tList = new ArrayList<Taxi>();
	public static List<Requests> rList = new ArrayList<Requests>();

	public static void main(String[] args) throws IOException{
		
		/*File fileName = new File("test1");
		BufferedReader reader = new BufferedReader(new FileReader(fileName));*/
		
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
		Scheduler schedulerObj = new Scheduler();
		
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
		obj.print("path matrix");
		obj.print("adjcency matrix");
		obj.findShortestPath();
		obj.print("shortest path matrix");
		
		text = reader.readLine();
		st = new StringTokenizer(text, " ");
		//System.out.println(text);
		for(int i=0;i<taxiCount;i++){
			int temp = Integer.parseInt(st.nextToken());
			//System.out.println(temp);
			Taxi taxiObj = new Taxi(i,temp-1,taxiCapacity);
			tList.add(taxiObj);
		}
		obj.print("taxi list");
		
		for( int i = 0; i < requestCount; i++){
			text = reader.readLine();
			st = new StringTokenizer(text, " ");
			int temp1 = Integer.parseInt(st.nextToken())-1;
			int temp2 = Integer.parseInt(st.nextToken())-1;
			int temp3 = Integer.parseInt(st.nextToken());
			int temp4 = Integer.parseInt(st.nextToken());
			Requests reqObj = new Requests(temp1,temp2,temp3,temp4);
			rList.add(reqObj);
		}
		obj.print("requests list");
		
		obj.sortRequests(requestCount);
		//obj.print("requests list");
		int income = schedulerObj.taxiScheduling(rList, tList);
		System.out.println("total revenue: "+income);
		
	}

}
