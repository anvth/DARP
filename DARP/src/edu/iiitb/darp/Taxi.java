package edu.iiitb.darp;

import java.util.Stack;

public class Taxi {
	
	int taxiID;
	int startLoc;
	int currentLoc;
	int taxiCapacity;
	int[] destLoc = new int[5];
	int revenueEarned = 0;
	int noOfPassengers = 0;
	int timeElapsed = 0;
	private int top = -1;
	
	public Taxi(int taxiID, int startLoc, int taxiCapacity){
		
		this.taxiID = taxiID;
		this.startLoc = startLoc;
		this.taxiCapacity = taxiCapacity;
		this.currentLoc = this.startLoc;
	}

	public int getTaxiID() {
		return taxiID;
	}

	public void setTaxiID(int taxiID) {
		this.taxiID = taxiID;
	}

	public Object getDestLoc() {
		int temp =  destLoc[top];
		top--;
		return temp;
		
	}

	public void setDestLoc(int destLoc) {
		top++;
		this.destLoc[top] = destLoc;
	}

	public int getRevenueEarned() {
		return revenueEarned;
	}

	public void setRevenueEarned(int revenueEarned) {
		this.revenueEarned = revenueEarned;
	}

	public int getCurrentLoc() {
		return currentLoc;
	}

	public void setCurrentLoc(int currentLoc) {
		this.currentLoc = currentLoc;
	}

	public int getStartLoc() {
		return startLoc;
	}

	public void setStartLoc(int startLoc) {
		this.startLoc = startLoc;
	}

	public int getTaxiCapacity() {
		return taxiCapacity;
	}

	public void setTaxiCapacity(int taxiCapacity) {
		this.taxiCapacity = taxiCapacity;
	}

	public int getTimeElapsed() {
		return timeElapsed;
	}

	public void setTimeElapsed(int timeElapsed) {
		this.timeElapsed = timeElapsed;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
	
	

}
