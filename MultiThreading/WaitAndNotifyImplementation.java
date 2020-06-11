package JavaSynchronization;

import java.util.Scanner;

public class WaitAndNotifyImplementation {

	public void producer() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread is running... ");
			wait();
			System.out.println("Resumed...");
		}
	}

	public void consumer() throws InterruptedException {
		synchronized (this) {
			Thread.sleep(3000);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Waiting for return key.");
			scanner.nextLine();
			notify();
			Thread.sleep(5000);
		}
	}

	public static void main(String[] args) {

		WaitAndNotifyImplementation wn = new WaitAndNotifyImplementation();

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					wn.producer();
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
					wn.consumer();
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

	}

}
