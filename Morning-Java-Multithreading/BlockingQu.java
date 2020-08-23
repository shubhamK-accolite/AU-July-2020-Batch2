package accoliteTraining;

import java.util.ArrayList;
import java.util.List;

public class BlockingQu {

	public static void main(String[] args) {
		
		BQThread wt=new BQThread();
		int producerCount=10, consumerCount=10 ;
		
		for(int i=0;i<producerCount;i++) {
			Thread t1=new Thread(()->wt.put());
			t1.start();
			System.out.println("ProducerThread :"+t1.getName()+ " CREATED");
		}
		for(int i=0;i<consumerCount;i++) {
			Thread t2=new Thread(()->wt.take());
			t2.start();
			System.out.println("ConsumerThread :"+t2.getName()+ " CREATED");
			
		}
	
		
	}

}

class BQThread {
	
	private int maximumSize=100;
	private int minimum=0;
	private List<Integer> list=new ArrayList<>();
	private Object lock=new Object();
	private int number=0;
	public boolean val;
	
	public void put() {
		
		while(true) {
			synchronized(lock) {
				if(list.size()==maximumSize) {
					System.out.print("producerThread :"+Thread.currentThread().getName());
					System.out.println(" Queue is full. No task is already taken by any of the consumer");
					
					try {
						lock.wait();
					} catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					System.out.print("producerThread :"+Thread.currentThread().getName());
					System.out.print(" Current Queue Size :"+list.size());
					System.out.println(" Adding message "+number+" to the queue");
					
					list.add(number);
					number++;
					lock.notifyAll();
				}
				
			}
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void take() {
	
		while(true) {
			synchronized(lock) {
				if(list.size()==minimum) {
					System.out.print("consumerThread :"+Thread.currentThread().getName());
					System.out.println(" Queue is empty. There is no task present in the Queue");
					
					try {
						lock.wait();
					} catch(InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
				else {
					
					System.out.print("consumerThread :"+Thread.currentThread().getName());
					System.out.print(" Current Queue Size :"+list.size());
					System.out.println(" Removing message "+list.remove(0)+" from the queue.");
					lock.notifyAll();
				}
				
			}
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	
}

