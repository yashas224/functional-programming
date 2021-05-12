import java.util.Arrays;
import java.util.List;

public class FP01Structured {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 14, 56, 777, 8, 9, 0, 6, 3, 4);
		printInStructured(list);
		System.out.println("---------------------");
		printEnevNumbers(list);
	}

	private static void printEnevNumbers(List<Integer> list) {
		for (int i : list) {
			if (i % 2 == 0)
				System.out.println(i);
		}
	}

	private static void printInStructured(List<Integer> list) {
		for (int i : list) {
			System.out.println(i);
		}
	}

}
