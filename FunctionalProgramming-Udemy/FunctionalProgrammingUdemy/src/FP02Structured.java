import java.util.Arrays;
import java.util.List;

public class FP02Structured {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 14, 56, 777, 8, 9, 0, 6, 3, 4);
		System.out.println("--------Sum------------");

		int sum = addElements(list);
		System.out.println(sum);
	}

	private static int addElements(List<Integer> list) {
		int res = 0;
		for (int i : list) {
			res += i;
		}
		return res;
	}

}
