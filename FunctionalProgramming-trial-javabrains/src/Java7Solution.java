import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Java7Solution {

	public static void main(String[] args) {
		List<Person> list = Arrays.asList(new Person("yashas", "ssmaga", 26), new Person("arushi ", "chawala", 60),
				new Person("hrithik", "cidnfresX", 56), new Person("charli", "thomas", 56));
		System.out.println("BEFORE sorting ");
		printItems(list);
		// srt list by last name
		Collections.sort(list, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});

		// create amothids that printa all emlements
		System.out.println();
		System.out.println();
		System.out.println("AFTER sorting ");
		printItems(list);
		System.out.println();
		System.out.println();
		System.out.println("Custome Display");
		//
		printCustome(list, new Condition() {
			@Override
			public boolean check(Person p) {
				return p.getLastName().startsWith("c") || p.getLastName().startsWith("C");
			}
		});

	}

	private static void printCustome(List<Person> list, Condition c) {
		for (Person p : list) {
			if (c.check(p))
				System.out.println(p);
		}

	}

	private static void printItems(List<Person> list) {
		for (Person p : list) {
			System.out.println(p);
		}

	}

}

interface Condition {
	boolean check(Person p);
}
