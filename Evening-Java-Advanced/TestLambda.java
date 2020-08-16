/*2) Demonstrate that local variable used in lamda expression must be final or 
 *   effectively final and instance variable can be changed inside the lambda expression.
 **/

interface FuncInterface 
{ 
    // An abstract function 
    void abstractFun(int x); 
  
} 
  
class TestLambda 
{ 
    public static void main(String args[]) 
    { 
      	String myMessage = "Your marks: ";
        FuncInterface fobj = (int x)->{
          x++;			// instance variable changed
          System.out.println(myMessage+x);
        } ;
   		
      //	myMessage = "Your marks are :";    // Gives error :
      	
      	fobj.abstractFun(5); 
    } 
} 
