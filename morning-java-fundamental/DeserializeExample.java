import java.io.*;

public class DeserializeExample {
	 public static void main(String args[]){  
		  try{  
		  //Creating stream to read the object  
		  ObjectInputStream in=new ObjectInputStream(new FileInputStream("example.txt"));  
		  Student s=(Student)in.readObject();  
		  //printing the data of the serialized object  
		  System.out.println(s.id+" "+s.name+" "+s.marks);  
		  System.out.println("Transient fields :" + s.rollNumber+" "+s.subject);
		  //closing the stream  
		  in.close();  
		  }catch(Exception e){System.out.println(e);}  
		 }  
}
