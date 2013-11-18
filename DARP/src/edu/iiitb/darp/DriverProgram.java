package edu.iiitb.darp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DriverProgram {
	 

	public static List<Taxi> tList = new ArrayList<Taxi>();
	public static List<Requests> rList = new ArrayList<Requests>();
    public static int taxiCapacity, outputFlag = 0;
    static File inputFile;
    static File outputFile;
    
	public static void main(String[] args) throws IOException{
		
		if( args.length == 1){
			inputFile = new File(args[0]);
		}
		else  if(args.length == 2){
			inputFile = new File(args[0]);
			outputFile = new File(args[1]);
			outputFlag = 1;
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		
		String text = null;
		int locCount;
		int requestCount;
		int taxiCount;
		
		System.out.println("Reading inputs...");
		text = reader.readLine();
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
			st = new StringTokenizer(text," ");
			for(int j=0;j<locCount;j++){
				int temp = Integer.parseInt(st.nextToken());
				obj.insertLocation(i, j, temp);
			}
		}
		//obj.print("path matrix");
		//obj.print("adjcency matrix");
		obj.findShortestPath();
		//obj.print("shortest path matrix");
		
		text = reader.readLine();
		st = new StringTokenizer(text, " ");
		for(int i=0;i<taxiCount;i++){
			int temp = Integer.parseInt(st.nextToken());
			Taxi taxiObj = new Taxi(i,temp-1,taxiCapacity);
			tList.add(taxiObj);
		}
		//obj.print("taxi list");
		
		System.out.println("Sorting requests...");
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
		
		obj.sortRequests(requestCount);
		//obj.print("requests list");
		
		System.out.println("Scheduling taxis...");
		int income = schedulerObj.taxiScheduling(rList, tList);
		System.out.println("total revenue: "+income);
		
		
	}

}
