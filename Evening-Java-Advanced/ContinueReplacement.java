// Find the replacement of continue keyword when you are iterating over a collection using forEach() method.

import java.util.*;

class ContinueReplacement {
  
  public static void main(String[] args) {
    
    List<Integer> vals =new ArrayList<Integer>();
    vals.add(2);
    vals.add(3);
    vals.add(4);
    vals.add(5);
    vals.add(6);
    vals.add(7);
    vals.add(8);
    vals.add(14);
    vals.add(13);
    vals.add(11);
    vals.add(12);
    vals.add(10);
    vals.add(9);
    
    vals.forEach(x->System.out.print(x+" "));
    System.out.println("-----");
    vals.forEach(x->{
        if(x %3 ==0) return;
      	System.out.print(x+" ");
        });
	  
    
  }
}
