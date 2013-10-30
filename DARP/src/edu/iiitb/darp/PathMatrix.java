package edu.iiitb.darp;

public class PathMatrix {
	
	int[][] matrix;
	int locCount;
	
	public PathMatrix(int locCount){
		this.locCount = locCount;
		matrix = new int[this.locCount][this.locCount];		
	}
	
	public void insertLocation(int row,int col,int data){
		//System.out.println("data received to insert function: "+row+" "+col+" "+data);
		matrix[row][col] = data;
	}
	
	public void printLocations(){
		//System.out.println("in print location");
		for(int i=0;i<locCount;i++){
			for(int j=0;j<locCount;j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
