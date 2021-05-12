import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP02Functional {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 14, 56, 777, 8, 9, 0, 6, 3, 4);
		System.out.println("--------Sum------------");

		int sum = addElements(list);
		System.out.println(sum);

		System.out.println("--------Max number------------");
		int max = list.stream().reduce(Integer.MIN_VALUE, Math::max);
		System.out.println(max);

		System.out.println("--------Exerscise questions-------------------------------");

		list = Arrays.asList(1, 2, 6, 2, 2, 1, 10, 3, 4);
		sum = list.stream().map(n -> n * n).reduce(0, Integer::sum);
		System.out.println(sum);

		System.out.println("odd sum");
		System.out.println(list.stream().filter(i -> i % 2 != 0).reduce(0, Integer::sum));

		list.stream().distinct().forEach(i -> System.out.print(i));
		System.out.println("sorted");
		;
		list.stream().sorted().forEach(i -> System.out.println(i));
		System.out.println("reverse");
		;
		// list.stream().sorted((a, b) -> b.compareTo(a)).forEach(System.out::println);
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");
		courses.stream().sorted((a, b) -> {
			if (a.length() > b.length()) {
				return 0;
			} else if (a.length() < b.length()) {
				return -1;
			}

			return 0;
		}).forEach(System.out::println);

		List<Integer> doubleList = doubleList(list);
		System.out.println("-----------------double list--------------------");
		System.out.println(doubleList);

		List<Integer> evenList = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		System.err.println(evenList);

		List<Integer> listOfLengths = courses.stream().map(str -> str.length()).collect(Collectors.toList());
		System.out.println(listOfLengths); 
	}

	private static List<Integer> doubleList(List<Integer> list) {
		return list.stream().map(i -> 2 * i).collect(Collectors.toList());
	}

	private static int addElements(List<Integer> list) {
		// return list.stream().reduce(0, (a, b) -> add(a, b));
		// method reference
		// return list.stream().reduce(0, FP02Functional::add);
		// lambda
		return list.stream().reduce(0, (a, b) -> a + b);
		// (a, b) -> add(a, b) === FP02Functional::add
	}

	private static int add(int a, int b) {
		return a + b;
	}

}
