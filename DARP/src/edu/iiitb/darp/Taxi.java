package edu.iiitb.darp;



public class Taxi {
	
	int taxiID;
	int startLoc;
	int currentLoc;
	int Capacity;
	int revenueEarned = 0;
	int noOfPassengers = 0;
	int timeElapsed = 0;
	StringBuffer taxiBuffer = new StringBuffer(" ");
	
	public StringBuffer getTaxiBuffer() {
		return taxiBuffer;
	}

	public void setTaxiBuffer(StringBuffer taxiBuffer) {
		this.taxiBuffer = taxiBuffer;
	}

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
		   public int peek(int dest){
			   for(int i = top; i >= 0; i--){
				   if(dest == stackArray[i]){
					   return i;
				   }
			   }
			   return -1;
		   }
		   public int removeAt(int destIndex){
			   int locValue = stackArray[destIndex];
			   for(int i = destIndex; i < top; i++){
				   stackArray[i] = stackArray[i+1];
			   }
			   --top;
			   return locValue;
		   }
	}
	public Taxi(int taxiID, int startLoc, int taxiCapacity){
		
		this.taxiID = taxiID;
		this.startLoc = startLoc;
		Capacity = taxiCapacity;
		this.currentLoc = this.startLoc;
	}
	
	MyStack obj = new MyStack(MT2013127.taxiCapacity);

	public int getTaxiID() {
		return taxiID;
	}

	public void setTaxiID(int taxiID) {
		this.taxiID = taxiID;
	}

	public int getDestLoc() {
		return obj.pop();
	}
	
	public int removeAt(int destIndex){
		return obj.removeAt(destIndex);
	}
	
	public int lookForDest(int dest){
		return obj.peek(dest);
	}

	public void setDestLoc(int destLoc) {		
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
