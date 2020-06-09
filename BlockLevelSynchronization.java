package JavaSynchronization;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockLevelSynchronization {
	

	private Random random = new Random();
	private List<Integer> list1 = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();
	
	private Object lock1 = new Object();
	private Object lock2 = new Object();
	

	public  void stepOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			list1.add(random.nextInt(100));
		}
	}

	public  void stepTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			list2.add(random.nextInt(100));
		}
	}

	public void process() {
		for (int i = 0; i < 1000; i++) {
			stepOne();
			stepTwo();
		}
	}

	public void ruunerMethod() {
		
		long startTime = System.currentTimeMillis();

		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				process();
			}
		});
		System.out.println("Thread Startig -- ");
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();

		System.out.println("Time taken : " + (endTime - startTime));
		System.out.println("list1 size:"+ list1.size() + " , list2 size: "+list2.size());
	}

	
	public static void main(String[] args) {
		CustomClassLevelSynchronization classObj = new CustomClassLevelSynchronization();
		classObj.ruunerMethod();
	}


}
