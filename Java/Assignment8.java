import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class SharedResource {
	private volatile int sharedValue = 0; // Volatile to ensure visibility

	// Synchronized method for thread safety with respect to instance
	public synchronized void incrementSharedValue() {
		sharedValue++;
	}

	// Synchronized method to get sharedValue
	public synchronized int getSharedValue() {
		return sharedValue;
	}

	// Method with local variable for thread safety
	public void performOperation() {
		int localVar = 0; // Local variable is thread-safe
		// ... some operations with localVar
	}

	// Synchronized block for thread safety with respect to instance
	public void performSynchronizedBlock() {
		synchronized (this) {
			// ... critical section of code
		}
	}
}

class WorkerThread implements Runnable {
	private SharedResource sharedResource;

	public WorkerThread(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}

	@Override
	public void run() {
		// Access shared resource and perform operations
		sharedResource.incrementSharedValue();
		sharedResource.performOperation();
		sharedResource.performSynchronizedBlock();
	}
}

public class Assignment8 {

	public static void main(String[] args) {
		// Create a shared resource
		SharedResource sharedResource = new SharedResource();

		// Create a thread pool executor
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// Submit tasks to the thread pool
		for (int i = 0; i < 10; i++) {
			Runnable workerThread = new WorkerThread(sharedResource);
			executorService.submit(workerThread);
		}

		// Shut down the thread pool
		executorService.shutdown();

		// Wait for all threads to finish
		try {
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Display the final value of the shared resource
		System.out.println("Final value of shared resource: " + sharedResource.getSharedValue());
	}
}