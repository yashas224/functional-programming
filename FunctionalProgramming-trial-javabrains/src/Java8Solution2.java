import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Java8Solution2 {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("yashas", "ssmaga", 26), new Person("arushi ", "chawala", 60),
				new Person("hrithik", "coshan", 56), new Person("charli", "thomas", 56));
		System.out.println("BEFORE sorting ");

		performConditionally(list, p -> true, p -> System.out.println(p));
		// srt list by last name
		Collections.sort(list, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		// create amothids that printa all emlements
		System.out.println();
		System.out.println();
		System.out.println("AFTER sorting ");
		performConditionally(list, p -> true, p -> System.out.println(p));

		System.out.println();
		System.out.println();
		System.out.println("Custome Display");

		// prinat people whse last name begins woth s
	}

	private static void performConditionally(List<Person> list, Predicate<Person> predicate,
			Consumer<Person> consumer) {
		for (Person p : list) {
			if (predicate.test(p))
				consumer.accept(p);
		}

	}
}
