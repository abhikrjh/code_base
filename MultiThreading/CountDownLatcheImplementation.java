package JavaSynchronization;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatcheImplementation {
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(3);
		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 4; i++) {
			executor.submit(new Processor1(latch));
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Completed!!");
	}
}

class Processor1 implements Runnable {

	CountDownLatch latch = new CountDownLatch(3);

	public Processor1(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
		System.out.println("Started");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		latch.countDown();
	}

}
