import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class FunctionalOne {
	public void greet(Greeting greeting) {
		greeting.perform();
	}

	Integer obj;

	public static void main(String[] args) {
		FunctionalOne obj = new FunctionalOne();

		// OOP interfce impl
		Greeting implObj = new GreetingImpl();
		obj.greet(implObj);
		// lambda experession on funcyioal Interface only- ie having one abstract methid
		// only
		Greeting lambda = () -> System.out.println("Greeting from IMPL LAMBDAS");

		obj.greet(lambda);
		//
		// anonmyus inner class
		Greeting innerClass = new Greeting() {
			@Override
			public void perform() {
				System.out.println("Greeting from IMPL Inner class ");
			}
		};

		obj.greet(innerClass);

		MyLambda inner1 = new MyLambda() {
			@Override
			public void m1() {
				System.out.println("m1 impl");
			}

			@Override
			public void m2() {
				System.out.println("m2 impl");
			}
		};
		//

		inner1.m1();
		inner1.m2();
		// obj.greet(lambda);
		//
		// List<Integer> list = new ArrayList<>();
		// list.add(1);
		// list.add(2);
		// list.add(3);
		// list.add(4);
		// list.add(6);
		// list.add(19);
		//// System.out.println(list);
		//
		// // using predicate fuctiona interface
		//
		// list.removeIf(new Predicate<Integer>() {
		//
		// @Override
		// public boolean test(Integer t) {
		// return t<3;
		// }
		//
		// });
		//
		// Predicate<Integer> predicate = t -> t < 3;
		// list.removeIf(predicate);
		// System.out.println(list);

		// Runnable
		// Thread
		// -------------------------------------------------------------------------------------------------------------------------------------------------
		// using consumer functionl interface
		//
		// list.stream().forEach(new Consumer<Integer>() {
		//
		// @Override
		// public void accept(Integer t) {
		// System.out.println(t);
		// }
		//
		// });
		// Consumer<Integer> consumer = t -> System.out.println(t);
		// list.stream().forEach(consumer);

		// -------------------------------------------------------------------------------------------------------------------------------------------------
		// using Function functional interface
		// List<Integer> result = new ArrayList<>();
		// list.stream().map(new Function<Integer, Integer>() {
		// @Override
		// public Integer apply(Integer t) {
		// // TODO Auto-generated method stub
		// return 2*t;
		// }
		//
		// }).forEach(s -> result.add(s));

		// Function<Integer, Integer> function = t -> 2 * t;
		// list.stream().map(t -> 2 * t).forEach(n -> result.add(n));
		// System.out.println(result);

		// -------------------------------------------------------------------------------------------------------------------------------------------------
		// Random ran= new Random();
		// List<Integer> result = new ArrayList<>();
		//
		// IntStream.generate(()->ran.nextInt(100)).forEach(t-> result.add(t));
		// System.out.println(result);

	}

}

interface MyLambda {
	void m2();

	void m1();
}