import java.util.Arrays;
import java.util.List;

public class FP01Functional {
	int i;

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 14, 56, 777, 8, 9, 0, 6, 3, 4);
		printInFunctional(list);
		System.out.println("--------------");
		printEvenFunctional(list);
		System.out.println("--------------");
		printSquaresOfNumbers(list);
	}

	// private static void print(int n) {
	// System.out.println(n);
	// }

	private static void printSquaresOfNumbers(List<Integer> list) {
		list.stream().map(i -> i * i).forEach(System.out::println);

	}

	private static void printInFunctional(List<Integer> list) {
		// list.stream().forEach(t -> print(t));
		// using method reference
		// t -> print(t) === FP01Structured::print

		list.stream().forEach(System.out::println);

	}

	private boolean isEven(int number) {
		return number % 2 == 0;
	}

	private static void printEvenFunctional(List<Integer> list) {
		FP01Functional obj = new FP01Functional();
		obj.i += 6;
		// using method reference
		// list.stream().filter(n -> obj.isEven(n)).forEach(System.out::println);
		// n -> obj.isEven(n) ===obj::isEven
		list.stream().filter(obj::isEven).forEach(System.out::println);
	}

}
