package JavaSynchronization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* A semaphore controls access to a shared resource through the use of a counter. 
 * If the counter is greater than zero, then access is allowed. If it is zero, then access is denied. 
 * What the counter is counting are permits that allow access to the shared resource. 
 * Thus, to access the resource, a thread must be granted a permit from the semaphore.
 */

public class SemaphoreImplementation {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			executor.submit(new Runnable() {
				@Override
				public void run() {
					Connection.getInstance().connect();
				}
			});
		}
		executor.shutdown();

		try {
			executor.awaitTermination(1, TimeUnit.HOURS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Connection {
	private Semaphore semaphore = new Semaphore(10);
	private static Connection instance = new Connection();
	private int connections = 0;

	private Connection() {

	}

	public static Connection getInstance() {
		return instance;
	}

	public void connect() {
		
		try {
			semaphore.acquire();
			
			doConnect();
			
			semaphore.release();		
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void doConnect() {
		synchronized (this) {
			connections++;
		}
		System.out.println("Countions count are: " + connections);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			connections--;
		}
	}

}