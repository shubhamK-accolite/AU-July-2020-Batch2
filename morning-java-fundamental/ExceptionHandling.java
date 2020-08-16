/* 3 Exception :
 *	Write your own unchecked Exception and throw it from you counter programme which counts 1 to 100.
 *	 When you get Prime no while counting then throw this Exception and catch this to print you exception message.
 **/

class MyException extends Exception {
	
}

public class ExceptionHandling {
	
	public static void main(String[] args){
		
		for(int i=2;i<=100;i++){
			int flag =1;
			for(int j=2;j<=Math.sqrt(i);j++){
				
				if(i%j==0){
					flag =0;
					break;
				}
			}
			try{
			 if(flag==1){
				throw new MyException();	
			 }
			}catch (MyException e){
				System.out.println("Prime Number Exception :"+i);
			}
		}
		
	}
}
