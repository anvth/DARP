package edu.iiitb.darp;



public class Taxi {
	
	int taxiID;
	int startLoc;
	int currentLoc;
	int Capacity;
	int revenueEarned = 0;
	int noOfPassengers = 0;
	int timeElapsed = 0;
	
	public class MyStack {

		
		private int maxSize;
		   private int[] stackArray;
		   private int top;
		   public MyStack(int s) {
		      maxSize = s;
		      stackArray = new int[maxSize];
		      top = -1;
		   }
		   public void push(int j) {
			  //System.out.println(top);
		      stackArray[++top] = j;
		   }
		   public int pop() {
			  // System.out.println("calling pop "+top);
		      return stackArray[top--];
		   }
		   public boolean isEmpty() {
			      return (top == -1);
		   }
	}
	public Taxi(int taxiID, int startLoc, int taxiCapacity){
		
		this.taxiID = taxiID;
		this.startLoc = startLoc;
		Capacity = taxiCapacity;
		this.currentLoc = this.startLoc;
	}
	
	MyStack obj = new MyStack(DriverProgram.taxiCapacity);

	public int getTaxiID() {
		return taxiID;
	}

	public void setTaxiID(int taxiID) {
		this.taxiID = taxiID;
	}

	public int getDestLoc() {
		/*System.out.println("calling dest loc at: "+top);
		int temp =  destLoc[top];
		top--;*/
		return obj.pop();
		
	}

	public void setDestLoc(int destLoc) {
		/*this.destLoc[top] = destLoc;*/
		
		obj.push(destLoc);
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
		return Capacity;
	}

	public void setTaxiCapacity(int taxiCapacity) {
		this.Capacity = taxiCapacity;
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
