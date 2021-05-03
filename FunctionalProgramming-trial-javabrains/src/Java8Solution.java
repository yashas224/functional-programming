import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Java8Solution {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("yashas", "ssmaga", 26), new Person("arushi ", "chawala", 60),
				new Person("hrithik", "cidnfresX", 56), new Person("charli", "thomas", 56));
		System.out.println("BEFORE sorting ");
		printCustome(list, p -> true);
		Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// create amothids that printa all emlements
		System.out.println();
		System.out.println();
		System.out.println("AFTER sorting ");
		printCustome(list, p -> true);

		System.out.println();
		System.out.println();
		System.out.println("Custome Display");

		printCustome(list, (p) -> p.getLastName().startsWith("c"));

	}

	private static void printCustome(List<Person> list, Predicate<Person> predicate) {
		for (Person p : list) {
			if (predicate.test(p))
				System.out.println(p);
		}

	}

}
