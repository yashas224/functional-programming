public class FP05Threads {

	public static void main(String[] args) throws Exception {
		// no diff thread is created
		new Thread(() -> System.out.println("Thread concept by yashas from :" + Thread.currentThread().getName()))
				.run();

		// a new thread with its own stack is created
		new Thread(() -> System.out.println("Thread concept by yashas from :" + Thread.currentThread().getName()))
				.start();
	}

}
