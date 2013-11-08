package edu.iiitb.darp;

import java.util.List;

public class Scheduler {
	
	public int taxiScheduling(List<Requests> rList, List<Taxi> tList){
		
	
		for(int i = 0; i < rList.size(); i++){
			
			for ( int j = 0; j < tList.size(); j++){
				
				if((((Requests) rList.toArray()[i]).getSource() == ((Taxi) tList.toArray()[j]).getStartLoc())
							&& (((Taxi) tList.toArray()[j]).getTaxiCapacity() <= 5)  
							&& ((((Requests) rList.toArray()[i]).getFirstpickup() <= ((Taxi) tList.toArray()[j]).getTimeElapsed()))
							&& ((((Requests) rList.toArray()[i]).getLastpickup() >= ((Taxi) tList.toArray()[j]).getTimeElapsed()))
							&& (((Requests) rList.toArray()[i]).isStatus()==false)){
						
						System.out.println("Found a taxi: "+((Taxi) tList.toArray()[j]).getTaxiID());
						
						int temp = (((Taxi) tList.toArray()[j]).getNoOfPassengers());
						((Taxi) tList.toArray()[j]).setNoOfPassengers(temp+1);
						System.out.println("no of passengers in: "+((Taxi) tList.toArray()[j]).getNoOfPassengers());
						
						int row = ((Requests) rList.toArray()[i]).getSource();
						int col = ((Requests) rList.toArray()[i]).getDestination();
						
						temp = (((Taxi) tList.toArray()[j]).getRevenueEarned() + PathMatrix.shortestPath[row][col]); 
						((Taxi) tList.toArray()[j]).setRevenueEarned(temp);
						
						((Taxi) tList.toArray()[j]).setDestLoc(((Requests) rList.toArray()[i]).getDestination());
						System.out.println("Taxi destined to: "+((Taxi) tList.toArray()[j]).getDestLoc());
						System.out.println("Cost of ride"+ PathMatrix.shortestPath[row][col]);
						System.out.println("Revenue earned: "+((Taxi) tList.toArray()[j]).getRevenueEarned());
						((Requests) rList.toArray()[i]).setStatus(true);
						System.out.println("*******************************");
				}//end if location match
			}//end for tList
		}//end for rList
		
		
		int income = 0;
		for(int i = 0; i < tList.size(); i++){
			income = income + ((Taxi) tList.toArray()[i]).getRevenueEarned();
		}
		
		
		return income;
		
	}//end of method taxiScheduling
}//end of class Scheduler
