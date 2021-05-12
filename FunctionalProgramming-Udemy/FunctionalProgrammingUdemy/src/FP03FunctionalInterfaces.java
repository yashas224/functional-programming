import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class FP03FunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 76, 5);
		list.stream().filter(i -> i % 2 == 0).map(i -> i * i).forEach(System.out::println);
		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println(sum);

		System.out.println("Enen");
		traverse(x -> x % 2 == 0, x -> System.out.println(x), list);
		System.out.println("ODD");
		traverse(x -> x % 2 != 0, x -> System.out.println(x), list);

		System.out.println("multiples of 3");
		traverse(x -> x % 3 == 0, x -> System.out.println(x), list);
//		list.parallelStream().reduce(accumulator)
//		UnaryOperator<T>
//		BiPredicate<T, U>
//		BiFunction<T, U, R>
//		BiConsumer<T, U>
		
		
	}

	private static void traverse(Predicate<Integer> predicte, Consumer<Integer> consumer, List<Integer> list) {
		list.stream().filter(predicte).forEach(consumer);
	}
}
