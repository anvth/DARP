package edu.iiitb.darp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Scheduler {
	 
	
	public int taxiScheduling(List<Requests> rList, List<Taxi> tList) throws IOException{
		
		Random rand = new Random();
		int income = 0, k=0, satisfied = 0;
		String content = null;
		
		if(!DriverProgram.outputFile.exists()){
			DriverProgram.outputFile.createNewFile();
		}
		FileWriter fw = new FileWriter(DriverProgram.outputFile.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		while(k<rList.size()){
		for(int i = 0; i < rList.size(); i++){
			
			for ( int j = 0; j < tList.size(); j++){
				
				if(((((Requests) rList.toArray()[i]).getSource() == ((Taxi) tList.toArray()[j]).getStartLoc())
							|| (((Requests) rList.toArray()[i]).getSource() == ((Taxi) tList.toArray()[j]).getCurrentLoc()))
						    && ((Taxi) tList.toArray()[j]).getNoOfPassengers() < ((Taxi) tList.toArray()[j]).getTaxiCapacity()
							&& ((((Requests) rList.toArray()[i]).getFirstpickup() <= ((Taxi) tList.toArray()[j]).getTimeElapsed()))
							&& ((((Requests) rList.toArray()[i]).getLastpickup() >= ((Taxi) tList.toArray()[j]).getTimeElapsed()))
							&& (((Requests) rList.toArray()[i]).isStatus()==false)){
					
						//System.out.println("Request number: "+i);
						content = "Request number: "+i+"\n";
						bw.append(content);
							
						
						//System.out.println("Found a taxi: "+((Taxi) tList.toArray()[j]).getTaxiID());
						content = "Found a taxi: "+((Taxi) tList.toArray()[j]).getTaxiID()+" \n";
						bw.append(content);
						
						int temp = (((Taxi) tList.toArray()[j]).getNoOfPassengers());
						((Taxi) tList.toArray()[j]).setNoOfPassengers(temp+1);
						//System.out.println("no of passengers in: "+((Taxi) tList.toArray()[j]).getNoOfPassengers());
						content="no of passengers in: "+((Taxi) tList.toArray()[j]).getNoOfPassengers()+" \n";
						bw.append(content);
						
						int row = ((Requests) rList.toArray()[i]).getSource();
						int col = ((Requests) rList.toArray()[i]).getDestination();
						
						temp = (((Taxi) tList.toArray()[j]).getRevenueEarned() + PathMatrix.shortestPath[row][col]); 
						((Taxi) tList.toArray()[j]).setRevenueEarned(temp);
						
						((Taxi) tList.toArray()[j]).setDestLoc(((Requests) rList.toArray()[i]).getDestination());
						//System.out.println("Taxi destined to: "+((Taxi) tList.toArray()[j]).getDestLoc());
						//System.out.println("Cost of ride"+ PathMatrix.shortestPath[row][col]);
						content = "Cost of ride"+ PathMatrix.shortestPath[row][col]+" \n";
						bw.append(content);
						
						//System.out.println("Revenue earned: "+((Taxi) tList.toArray()[j]).getRevenueEarned());
						content = "Revenue earned: "+((Taxi) tList.toArray()[j]).getRevenueEarned()+"\n";
						bw.append(content);
						
						//System.out.println("Time of pick up: "+((Taxi) tList.toArray()[j]).getTimeElapsed());
						content = "Time of pick up: "+((Taxi) tList.toArray()[j]).getTimeElapsed()+"\n";
						bw.append(content);
						((Requests) rList.toArray()[i]).setStatus(true);
						//System.out.println("Request satisfied count: "+(++satisfied));
						content = "Request satisfied count: "+(++satisfied)+"\n";
						bw.append(content);
						//System.out.println("*******************************");
						content = "*******************************\n";
						bw.append(content);
						System.out.println(((Taxi) tList.toArray()[j]).getTaxiID()+" "+((Taxi) tList.toArray()[j]).getCurrentLoc()+" "+((Taxi) tList.toArray()[j]).getTimeElapsed()+" "+((Taxi) tList.toArray()[j]).getNoOfPassengers());
						
				}//end if location match
			}//end for tList
		}//end for rList
	
		for( int j = 0; j < tList.size(); j++){
			
			if(((Taxi) tList.toArray()[j]).getTimeElapsed() < 1440){
			
				int newLoc;
				int newTime;
				
				do{
					newLoc = rand.nextInt(PathMatrix.locCount);
				}while( PathMatrix.adjMatrix[((Taxi) tList.toArray()[j]).getCurrentLoc()][newLoc]!=1);
				
				newTime = (int) (((Taxi) tList.toArray()[j]).getTimeElapsed() + (PathMatrix.shortestPath[((Taxi) tList.toArray()[j]).getCurrentLoc()][newLoc]*(1.1)));
				
				((Taxi) tList.toArray()[j]).setTimeElapsed(newTime);
							
				((Taxi) tList.toArray()[j]).setCurrentLoc(newLoc);
				
				int temp = ((Taxi) tList.toArray()[j]).lookForDest(((Taxi) tList.toArray()[j]).getCurrentLoc());
				
				if(temp >= 0){
					newLoc = ((Taxi) tList.toArray()[j]).removeAt(temp);
					((Taxi) tList.toArray()[j]).setCurrentLoc(newLoc);
					int tempPassengerCount = (((Taxi) tList.toArray()[j]).getNoOfPassengers());
					((Taxi) tList.toArray()[j]).setNoOfPassengers(tempPassengerCount-1);
				}
				
				//System.out.println(((Taxi) tList.toArray()[j]).getTaxiID()+" -> "+/*((Taxi) tList.toArray()[j]).getStartLoc()+" -> "+*/((Taxi) tList.toArray()[j]).getCurrentLoc()+" ->"+((Taxi) tList.toArray()[j]).getTimeElapsed());
			}
			
			if(((Taxi) tList.toArray()[j]).getNoOfPassengers() == ((Taxi) tList.toArray()[j]).getTaxiCapacity()){
				int newLoc = 0;
				int newTime;
				//while(((Taxi) tList.toArray()[j]).getNoOfPassengers() > 0){
				newLoc = ((Taxi) tList.toArray()[j]).getDestLoc();
				newTime = (int) (((Taxi) tList.toArray()[j]).getTimeElapsed() + (PathMatrix.shortestPath[((Taxi) tList.toArray()[j]).getCurrentLoc()][newLoc]*(1.1)));
				
				((Taxi) tList.toArray()[j]).setTimeElapsed(newTime);
							
				((Taxi) tList.toArray()[j]).setCurrentLoc(newLoc);
				int temp = (((Taxi) tList.toArray()[j]).getNoOfPassengers());
				((Taxi) tList.toArray()[j]).setNoOfPassengers(temp-1);
				//System.out.println("Passenger dropped: "+" "+((Taxi) tList.toArray()[j]).getTaxiID()+" "+(((Taxi) tList.toArray()[j]).getCurrentLoc()+" "+(((Taxi) tList.toArray()[j]).getTimeElapsed())+" "+(((Taxi) tList.toArray()[j]).getNoOfPassengers())));
				//}
			}	
		}
		
		k++;
		//System.out.println(k);
		}
		bw.close();
		for(int i = 0; i < tList.size(); i++){
			income = income + ((Taxi) tList.toArray()[i]).getRevenueEarned();
			//System.out.println("Revenue of "+((Taxi) tList.toArray()[i]).getTaxiID()+" "+((Taxi) tList.toArray()[i]).getRevenueEarned());
		}
		return income;
		
	}//end of method taxiScheduling
}//end of class Scheduler
