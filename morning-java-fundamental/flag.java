package accolite;

/*package whatever //do not write package name here */
import java.io.*;

class flag {
	public static void main (String[] args) {
	    
	    for(int i=0; i<71;i++)
		    System.out.print("_");
		System.out.println("_");    
		for(int i=0;i<9;i++){
		    for(int j=0;j<50;j++){
		        if(j<11){
		        if((i+j)%2 == 0) {
		           System.out.print(" * ");
		        }else {
		             System.out.print("   ");
		        }
		        }else {
		        	System.out.print("_");
		        }
		    }
		    	System.out.println("");  
		}
	
		for(int i=0; i<8; i++){
			for(int j=0; j<72; j++)
				System.out.print("_"); 
			System.out.println("");  
		}	
	}
}
