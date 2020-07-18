package JavaSynchronization;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* Important
There are two ways of creating threads – one by extending the Thread class and other by creating a thread with a Runnable. 
However, one feature lacking in  Runnable is that we cannot make a thread return result when it terminates, 
i.e. when run() completes. 
For supporting this feature, the Callable interface is present in Java.
*/
class CallableExample implements Callable<Integer>{
	@Override
	public Integer call() throws Exception {
		Random random = new Random();
		Integer i = random.nextInt(10);
		return i;
	}
}



public class CalableAndFutureImpl {

	
	public static void main(String[] args) {
		
		FutureTask<Object>[] randomNumberTask = new FutureTask[7];
		
		for(int i=0; i<7 ; i++) {
		   randomNumberTask[i] = new FutureTask(new CallableExample());
           Thread t1 = new Thread(randomNumberTask[i]);
           t1.start();
		}
		
		for (int i = 0; i < 7; i++) {
			try {
				System.out.println(randomNumberTask[i].get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
