import java.util.function.BiConsumer;

public class ExceptionHandling {
	public static void main(String[] rgs) {
		int[] arr = { 1, 2, 3, 5 };
		int key = 0;

		// // solution 1
		// proess(arr, key, (x, y) -> {
		// try {
		// System.out.println(x / y);
		// } catch (Exception e) {
		// System.out.println("Exception happened insidde the lambdaa");
		// }
		// });

		// SOLUTION 2
		System.out.println("-----------------------------------------");
		proess(arr, key, wrapper((x, y) -> {
			System.out.println("Lambda");
			System.out.println(x / y);
		}));
	}

	private static void proess(int[] arr, int key, BiConsumer<Integer, Integer> consumer) {
		for (int nos : arr) {
			consumer.accept(nos, key);
		}

	}

	private static BiConsumer<Integer, Integer> wrapper(BiConsumer<Integer, Integer> cousumer) {
		return (x, y) -> {
			try {
				System.out.println("wrapper");
				cousumer.accept(x, y);
			} catch (Exception e) {
				System.out.println("Exception happened insidde the Wrapper");
			}

		};
	}
}
