package JavaSynchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* IMPORTANT 
ExecutorService abstracts away many of the complexities associated with the lower-level abstractions like raw Thread. 
It provides mechanisms for safely starting, closing down, submitting, executing, and blocking on the successful or 
abrupt termination of tasks (expressed as Runnable or Callable).
*/
public class ExecutorServiceImplementation {
	
	 public static void main(String[] args) {
		 ExecutorService executor = Executors.newFixedThreadPool(2);
		 
		 for(int i=0; i<7; i++) {
			 executor.submit(new Processor(i));
		 }
		 
		 executor.shutdown();
		 
		 System.out.println("All task Submitted");
		 
		 try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 System.out.println("All Task completed!!");
	}

}


class Processor implements Runnable{
	
	private int id;
	
	Processor(int id){
		this.id= id;
	}

	@Override
	public void run() {
        System.out.println("Starting task: "+id);
        try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Completed Task: "+id);
	}
	
}