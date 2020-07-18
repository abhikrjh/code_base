package JavaSynchronization;

/*The consumers halt consuming if the size of queue is 0 (empty) and resumes consuming once the queue has an element. 
Blocking Queue solves much of the problem of synchronization mechanism handled by wait() and notify() in producer-consumer problem. 
The blockingQueue has methods take() and put which uses java. util.*/

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerProblem {
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
	
	private static void producer() throws InterruptedException{
        Random random = new Random();
        
        while(true) {
				queue.put(random.nextInt(100));
        }
	}
	
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
				
		while(true) {
			Thread.sleep(1000);
			
			if(random.nextInt(10) == 7) {
				Integer value = queue.take();
				
				System.out.println("Taken Value: "+value +" queue size: "+queue.size());
			}
		}
	}
	
	public static void main(String[] args) {
		
		Thread t1= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
				 producer();
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		Thread t2= new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
