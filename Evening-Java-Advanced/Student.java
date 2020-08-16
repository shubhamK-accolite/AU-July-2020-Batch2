import java.util.*;


interface Marks {
  	int normalize(int x);
  
  	public static double percentage(double marks, double totalMarks){
      	return (marks/totalMarks)*100;
    }
  
  	 public default Double getAverageMarks(List<Double> students) {
        if (Objects.isNull(students) || students.isEmpty()) {
            return null;
        }
        Double totalMarks = 0.0;
        for (Double marks : students) {
            totalMarks += marks;
            
        }
        return (totalMarks * 1.0) / students.size();
    }
}

interface StudentEmpty {
    Student get();
}
interface StudentWithName {
    Student get(String name);
}

class Student {
  
  private String name;
  
  Student(){
    System.out.println("Default Constructor called");
  }
  
  Student(String name){
     System.out.println("Name Constructor");
        this.name = name;
  }
  
  public static void main(String[] args) {
    
    
    int m = 200;
    
    // Lambda function
    Marks m1 = (int x)->x/10; 
    int normalizedMarks = m1.normalize(m);
    System.out.println("Lambda: Normalized"+normalizedMarks);
    
    // Using static Method
     double myMarks = 57, total = 70; 
     double percent = Marks.percentage(myMarks,total);
      System.out.println("Static : Percentage "+percent);
    
    // Using Default method reference
    List<Double> allstudents= new ArrayList<Double>();
    allstudents.add(23.0);
    allstudents.add(55.5);
    allstudents.add(34.7);
    allstudents.add(12.6);
    allstudents.add(45.0);
    
    System.out.println("Default : Avg Marks : "+m1.getAverageMarks(allstudents));
    
    // Using Empty Constructor
    StudentEmpty stud1 = Student::new;
	System.out.println("Constructor isn't called yet...");
	System.out.println(stud1.get());
    
    // Using name Constructor
     StudentWithName stud2 = Student::new;
	 System.out.println("Constructor isn't called yet...");
	 System.out.println(stud2.get("Shubham"));

  }
}
