package accolite;
import java.util.ArrayList;
import java.util.EmptyStackException;
//import java.util.Scanner;
import java.util.Stack;

public class calc {
	
	static int Precedence(char ch) 
    { 
        switch (ch) 
        { 
       
        case '+': 
        case '-': 
        	return 1; 
       
        case '*': 
        case '/': 
        case '%':	
            return 2;  
        } 
        return -1; 
    } 
	
	static ArrayList<String> infixToPostfix(String exp) 
    { 
		
        ArrayList<String> postExp = new ArrayList<String>(); 
        ArrayList<String> InvalidExp = new ArrayList<String>();
        InvalidExp.add("Invalid Expression");
        
        Stack<String> stack = new Stack<String>(); 
        int sign=0;  
        for (int i = 0; i<exp.length(); ++i) 
        { 
        	 //System.out.println("Inloop:"+i);
            char ch = exp.charAt(i); 
            String temp = "";  
             
            if (Character.isDigit(ch)){  // expression digit
            	temp  += ch;          	
            	while(i+1< exp.length() && Character.isDigit( exp.charAt(i+1))){
            		ch = exp.charAt(i+1);
            		temp =  temp + ch;
            		i++;
            	}
            	if(sign==1){ 
            		temp = "-"+temp;
            		sign =0;
            	}
            	postExp.add(temp); 
            }
            else if (ch == '(') { 
            	temp += ch;
                stack.push(temp);
            }    
            else if (ch == ')') 
            { 
                while (!stack.isEmpty() && stack.peek() != "(") 
                	postExp.add(stack.pop()); 
                  
                if (!stack.isEmpty() && stack.peek() != "("){ 
                    return InvalidExp;    
                }    
                else{
                    try {
                        stack.pop();
                     } catch (EmptyStackException e) {
                     }
                }   
            } 
            else // an operator is encountered 
            { 
            	if(ch =='-' && (i==0 || !Character.isDigit(exp.charAt(i-1)) ) ){
            		sign =1; // checking for negative number
            	}else { 
            		            	
		                while (!stack.isEmpty() && Precedence(ch) <= Precedence((stack.peek()).charAt(0))){ 
		                    if(stack.peek() =="(") 
		                        return InvalidExp; 
//		                    System.out.println("Add to exp. :"+StackPeek);
		                    	postExp.add(stack.pop()); 
		                  
		                }
		                temp += ch;
		                stack.push(temp);
	                
            	}
            } 
       
        } 
       
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.peek() == "(") 
                return InvalidExp; 
        try {    
            postExp.add(stack.pop()); 
        } catch (EmptyStackException e) {
        }
         } 
        return postExp; 
    } 
	
	static Integer calcPostfix(ArrayList<String> Expr){
		
		Stack<Integer> stack = new Stack<Integer>();
		//stack.push(0);
		for(int i=0;i< Expr.size();i++){
			String cur = Expr.get(i);
			int nextpush =0;
			//System.out.print(cur);
			if(cur.equals("+") || cur.equals("*") || cur.equals("-") || cur.equals("/") || cur.equals("%")){
				int val1 = stack.pop();
				int val2 = stack.pop();
				
				if(cur.equals("+")) nextpush= val1+val2;
				if(cur.equals("-")) nextpush = val2-val1;
				if(cur.equals("/")) nextpush = val2/val1;
				if(cur.equals("*")) nextpush = val1*val2;
				if(cur.equals("%")) nextpush = val2%val1;
				
				stack.push(nextpush);
			}else {				// when number directly push
				try{
			
					nextpush = Integer.parseInt(cur);
					stack.push(nextpush);
				}
				 catch(NumberFormatException ex){}
			}

		}
		try{
			return stack.pop();
		}catch (EmptyStackException e) {
			return 1;
        }
	}
	
	public static void main (String[] args) {
	//	System.out.print("Enter expression: ");
	//	Scanner input = new Scanner(System.in);
	//		String myString = input.next();
    
       String myString[] = {"-5+8*6", "(55+9)%9","20+-3*5/8","5+15/3*2-8%3"};
       for(int i=0;i<4;i++){
	       System.out.println("Expression entered = " + myString[i]);
			// convert expression to postfix 
	        ArrayList<String> PostExpr = infixToPostfix(myString[i]); 
	      
//	        for (String Expr : PostExpr){
//	        	 System.out.print(Expr+" ");
//	        }
//	        System.out.println("");
	        
	        Integer ans = calcPostfix(PostExpr);
	        System.out.println("Answer :"+ans);
	        System.out.println("");
       }
//    
	}
}
