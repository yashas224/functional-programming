import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FP03Methodreference {

	public static void main(String[] args) {

		List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure",
				"Docker", "Kubernetes");

		// courses.stream().map(str -> str.toUpperCase()).forEach(t ->
		// System.out.println(t));

		// / method refernece
		courses.stream().map(String::toUpperCase).forEach(System.out::println);

		// Supplier<String> sup = () -> new String();

		// methid reference
		Supplier<String> sup = String::new;

		System.out.println(sup.get());
	}

}
