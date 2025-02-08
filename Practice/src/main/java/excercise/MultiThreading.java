package excercise;

public class MultiThreading {
	public static void main(String[] args) {
		int n=8;
		//shared Resource
				SharedResource sharedResource = new SharedResource();
		Runnable myThread = () -> {
			try {
				System.out.println("Thread "+Thread.currentThread().getId()+" is Running");
			}catch(Exception e) {
				System.out.println("Exception is Caught");
			}
		};
		for(int i=0; i<n; i++) {
//			MultiThreadingDemo obj = new MultiThreadingDemo();
//			obj.start();
//			Thread obj2 = new Thread(new MultiThreadingDemo2());
//			obj2.start();
//			Thread obj3 = new Thread(myThread);
//			obj3.start();
			//Shared Resource using synchronized
			MyThread thread1 = new MyThread(sharedResource);
			thread1.start();
			
		}
		
	}
}

class MultiThreadingDemo extends Thread {
	public void run() {
		try{
			System.out.println("Current Thread Runnig is "+Thread.currentThread().getName());
		}catch (Exception e) {
			System.out.println("Exception is Caught");
		}
	}
}

class MultiThreadingDemo2 implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Thread "+Thread.currentThread().getId()+" is Running");
		}catch(Exception e) {
			System.out.println("Exception is Caught");
		}
	}
}

class MyThread extends Thread {
	private final SharedResource sharedResource;
	
	MyThread(SharedResource sharedResource){
		this.sharedResource = sharedResource;
	}
	
	@Override
	public void run() {
		sharedResource.increment();
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class SharedResource {
	private int sharedValue = 0;
	
	public synchronized void increment() {
		int localVariable = sharedValue;
		localVariable++;
		sharedValue = localVariable;
		System.out.println(Thread.currentThread().getName()+" : Increment value is "+sharedValue);
	}
}