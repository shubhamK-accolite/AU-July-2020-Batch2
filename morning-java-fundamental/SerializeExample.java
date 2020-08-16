import java.io.*;

public class SerializeExample {
	 public static void main(String args[]){  
		  try{  
		  //Creating the object  
		  Student s1 =new Student(1,"Rajesh",243,"English",101 );  
		  
		  //Creating stream and writing the object  
		  FileOutputStream fout=new FileOutputStream("example.txt");  
		  ObjectOutputStream out=new ObjectOutputStream(fout);  
		  out.writeObject(s1);  
		  out.flush();  
		  //closing the stream  
		  out.close();  
		  System.out.println("Serialized");  
		  }catch(Exception e){System.out.println(e);}  
		 }  
}
