package JavaSynchronization;

import java.util.concurrent.locks.ReentrantLock;

/*  This is the most widely used implementation class of Lock interface. 
 *  This class implements the Lock interface in similar way as synchronized keyword.
 *  Apart from Lock interface implementation, ReentrantLock contains some utility methods to get the thread holding the lock, 
 *  threads waiting to acquire the lock etc.
 *  synchronized block are reentrant in nature i.e 
 *  if a thread has lock on the monitor object and if another synchronized block requires to have the lock on the same 
 *  monitor object then thread can enter that code block. 
 *  I think this is the reason for the class name to be ReentrantLock. 
 *  and thats why we can call one synchronized method from other synchronized method
*/
class Runner {
	
	private int count =0;
	
	private ReentrantLock reentrantLock= new ReentrantLock();

	public void increment() {
		for(int i=0; i<1000; i++) {
			count++;
		}
	}
	
	public void firstThread() throws InterruptedException {
		reentrantLock.lock();
		try {
			increment();
		} finally { // lock must be unlock inside finally block
			reentrantLock.unlock();
		}

	}

	public void secondThread() throws InterruptedException {
		reentrantLock.lock();
		try {
            increment();
		}finally {
			reentrantLock.unlock();	
		}
	}

	public void finished() {
        System.out.println("Count is:"+count);
	}

}

public class ReentrantLockImplementation {

	public static void main(String[] args) {

		Runner ri = new Runner();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					ri.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					ri.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
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
      ri.finished();
	}
}
