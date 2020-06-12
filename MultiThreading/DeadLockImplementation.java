package JavaSynchronization;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Account {

	private int balance = 7000;

	public int deposit(int amount) {
		return balance += amount;
	}

	public int withdraw(int amount) {
		return balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

	public static void transfer(Account acc1, Account acc2, int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}
}

public class DeadLockImplementation {
	private Account acc1 = new Account();
	private Account acc2 = new Account();

	// Creating lock
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	Random random = new Random();

	public void firstThread() throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			lock1.lock();
			lock2.lock();
			try {
				Account.transfer(acc1, acc2, random.nextInt(100));	
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
			
		}
	}

	public void secondThread() throws InterruptedException {
		for (int i = 0; i < 1000; i++) {
			
			// Dead Lock situation to avoid this we should  follow the same order of lock
			/*lock2.lock();
			lock1.lock();*/
			
			lock1.lock();
			lock2.lock();
			
			try {
				Account.transfer(acc2, acc1, random.nextInt(100));	
			}finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}

	public void finished() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
	}

	public static void detectDeadLock() {
		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		long[] threadIds = threadBean.findDeadlockedThreads();
		
		boolean isDeadLock = false;
		if (threadIds != null && threadIds.length > 0) {
			isDeadLock = true;
		}
		String s = isDeadLock ? "DeadLock occured" : "";
		if (isDeadLock) {
			System.out.println(s);	
		}
	}
	
	public static void main(String[] args) {
		DeadLockImplementation di = new DeadLockImplementation();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					di.firstThread();
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
					di.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		detectDeadLock();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		di.finished();
	}

}