import java.io.Serializable;
public class Student implements Serializable{  
 
	private static final long serialVersionUID = 1L;
int id;  
 String name; 
 transient int rollNumber;
 int marks;
 transient String subject;
 public Student(int id, String name, int rno,String sub, int marks) {  
  this.id = id;  
  this.name = name;  
  this.rollNumber = rno;
  this.subject = sub;
  this.marks = marks;
 }  
}  
