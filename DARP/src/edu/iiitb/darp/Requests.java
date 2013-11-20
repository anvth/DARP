package edu.iiitb.darp;

public class Requests {
	
	int source;
	int destination;
	int firstpickup;
	int lastpickup;
	boolean status = false;
	
	public int getSource() {
		return source;
	}
	
	public void setSource(int source) {
		this.source = source;
	}
	public int getDestination() {
		return destination;
	}
	public void setDestination(int destination) {
		this.destination = destination;
	}
	public int getFirstpickup() {
		return firstpickup;
	}
	
	public void setFirstpickup(int firstpickup) {
		this.firstpickup = firstpickup;
	}
	
	public int getLastpickup() {
		return lastpickup;
	}
	
	public void setLastpickup(int lastpickup) {
		this.lastpickup = lastpickup;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public Requests(int source, int destination, int firstpickup, int lastpickup){
		this.source = source;
		this.destination = destination;
		this.firstpickup = firstpickup;
		this.lastpickup = lastpickup;
	}

	
}
