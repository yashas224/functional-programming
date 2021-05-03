package unit3;

import java.util.Arrays;
import java.util.List;

public class StreamsExample {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("yashas", "ssmaga", 26), new Person("arushi ", "chawala", 60),
				new Person("hrithik", "croshan", 56), new Person("charli", "thomas", 56));

		System.out.println("ALLLL");
		// list.forEach(p -> System.out.println(p));
		list.stream().forEach(t -> System.out.println(t));

		 System.out.println();
		 System.out.println("----------------------------");
		//
		list.stream().filter(p -> p.getLastName().startsWith("c")).forEach(p -> System.out.println(p));
	}

}
