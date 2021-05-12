import java.util.Arrays;
import java.util.List;

public class FP01Exercises {
	int i;

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 14, 5, 7, 8, 9, 0, 6, 3, 4);
		printOddFunctional(list);
		System.out.println("--------------");
		List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");

		printAllCourses(courses);
		System.out.println("--------------");

		printSpring(courses);
		System.out.println("--------------");
		courses.stream().filter(c -> c.length() >= 4).forEach(System.out::println);

		System.out.println("-------cube of odd numbers------");
		list.stream().filter(i -> i % 2 != 0).map(i -> i * i).forEach(i -> System.out.println(i));

	}

	private static void printSpring(List<String> courses) {
		courses.stream().filter(c -> c.contains("Spring")).forEach(System.out::println);
	}

	private static void printAllCourses(List<String> courses) {
		courses.stream().forEach(c -> System.out.println(c));

	}

	private static void printOddFunctional(List<Integer> list) {
		list.stream().filter(n -> n % 2 != 0).forEach(System.out::println);

	}

}
