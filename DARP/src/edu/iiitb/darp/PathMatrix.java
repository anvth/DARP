package edu.iiitb.darp;


public class PathMatrix {
	
	int[][] matrix;
	public static int[][] shortestPath;
	public static int[][] adjMatrix;
	public static int locCount;
	
	public PathMatrix(int locCount){
		PathMatrix.locCount = locCount;
		matrix = new int[PathMatrix.locCount][PathMatrix.locCount];		
		shortestPath = new int[PathMatrix.locCount][PathMatrix.locCount];
		adjMatrix = new int[PathMatrix.locCount][PathMatrix.locCount];
	}
	
	
	
	public PathMatrix() {
		// TODO Auto-generated constructor stub
	}



	public int[][] getMatrix() {
		return matrix;
	}



	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}



	public int getLocCount() {
		return locCount;
	}



	public void setLocCount(int locCount) {
		PathMatrix.locCount = locCount;
	}



	public void insertLocation(int row,int col,int data){
		if( data == -1){
			matrix[row][col] = 999;
		}
		else{
			matrix[row][col] = data;
		}
		
		if( data == -1){
			adjMatrix[row][col] = 0;
		}
		else{
			adjMatrix[row][col] = 1;
		}
	}
	
	public void findShortestPath(){
		
		for(int i = 0; i < locCount; i++){
			for(int j = 0; j < locCount; j++){
				shortestPath[i][j] = matrix[i][j];
			}
		}
		
		for(int j = 0; j < locCount; j++){
			shortestPath[j][j] = 0;
		}
		
		
		for(int k=0;k<locCount;k++){
			for(int i=0;i<locCount;i++){
				for(int j=0;j<locCount;j++){
					if(shortestPath[i][j]<(shortestPath[i][k]+shortestPath[k][j])){
						shortestPath[i][j] = shortestPath[i][j];
					}
					else{
						shortestPath[i][j] = (shortestPath[i][k]+shortestPath[k][j]);
					}
				}
			}
			
		}		
	}
	
	public void sortRequests(int requestCount) {
		
			for( int i = 0; i <= requestCount-2; i++){
				for(int j=0;j<=(requestCount-2-i);j++){
					if(((Requests) MT2013127.rList.toArray()[j+1]).getFirstpickup() < ((Requests) MT2013127.rList.toArray()[j]).getFirstpickup()){
						int tempSource = ((Requests) MT2013127.rList.toArray()[j+1]).getSource();
						int tempDest = ((Requests) MT2013127.rList.toArray()[j+1]).getDestination();
						int tempFirstPickup = ((Requests) MT2013127.rList.toArray()[j+1]).getFirstpickup();
						int tempLastPickup = ((Requests) MT2013127.rList.toArray()[j+1]).getLastpickup();
					
						((Requests) MT2013127.rList.toArray()[j+1]).setSource(((Requests) MT2013127.rList.toArray()[j]).getSource()); 
						((Requests) MT2013127.rList.toArray()[j+1]).setDestination(((Requests) MT2013127.rList.toArray()[j]).getDestination());
						((Requests) MT2013127.rList.toArray()[j+1]).setFirstpickup(((Requests) MT2013127.rList.toArray()[j]).getFirstpickup());
						((Requests) MT2013127.rList.toArray()[j+1]).setLastpickup(((Requests) MT2013127.rList.toArray()[j]).getLastpickup());
					
						((Requests) MT2013127.rList.toArray()[j]).setSource(tempSource); 
						((Requests) MT2013127.rList.toArray()[j]).setDestination(tempDest);
						((Requests) MT2013127.rList.toArray()[j]).setFirstpickup(tempFirstPickup);
						((Requests) MT2013127.rList.toArray()[j]).setLastpickup(tempLastPickup);
					}
				}
			}
	}
	
	public void print(String control){
		//System.out.println("in print location");
		if(control.equalsIgnoreCase("path matrix")){
			System.out.println("PATH MATRIX");
			for(int i=0;i<locCount;i++){
				for(int j=0;j<locCount;j++){
					System.out.print(matrix[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("------------------------------");
		}
		else if(control.equalsIgnoreCase("shortest path matrix")){
			System.out.println("SHORTEST PATH MATRIX");
			for(int i=0;i<locCount;i++){
				for(int j=0;j<locCount;j++){
					System.out.print(shortestPath[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("------------------------------");
		}
		else if(control.equalsIgnoreCase("adjcency matrix")){
			System.out.println("ADJACENCY MATRIX");
			for(int i=0;i<locCount;i++){
				for(int j=0;j<locCount;j++){
					System.out.print(adjMatrix[i][j]+" ");
				}
				System.out.println();
			}
			System.out.println("------------------------------");
		}
		else if(control.equalsIgnoreCase("taxi list")){
			System.out.println("TAXI LIST");
			for(int i=0;i<MT2013127.tList.size();i++){
				System.out.println(((Taxi) MT2013127.tList.toArray()[i]).getTaxiID()+" -> "+((Taxi) MT2013127.tList.toArray()[i]).getCurrentLoc());
			}
			System.out.println("------------------------------");
		}
		else if(control.equalsIgnoreCase("requests list")){
			System.out.println("REQUESTS LIST");
			for(int i=0;i<MT2013127.rList.size();i++){
				System.out.println(((Requests) MT2013127.rList.toArray()[i]).getSource()+" -> "+((Requests) MT2013127.rList.toArray()[i]).getDestination()+" -> "+((Requests) MT2013127.rList.toArray()[i]).getFirstpickup()+" -> "+((Requests) MT2013127.rList.toArray()[i]).getLastpickup());
			}
			System.out.println("------------------------------");
		}
	}

}
