import java.util.stream.LongStream;

public class FP05Parallel {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sum = LongStream.range(0, 1000000000).sum();
		long end = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("time taken milliseconds :" + (end - start));
		System.out.println("------------------------------------------------------------------------");
		start = System.currentTimeMillis();
		long sum1 = LongStream.range(0, 1000000000).parallel().sum();
		end = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("time taken milliseconds :" + (end - start));

	}

}
