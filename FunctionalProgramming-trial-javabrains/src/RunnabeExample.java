import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class RunnabeExample {

	public static void main(String[] args) {
		// anonymus inner class
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println(
						"running thread using  anonymus inenr class and from ---" + Thread.currentThread().getName());

			}
		}).start();

		// // lambda
		Thread thread = new Thread(
				() -> System.out.println("running thread using lambda ---" + Thread.currentThread().getName()));

		thread.start();
		System.out.println("running thread from ---" + Thread.currentThread().getName());

	}

}
