import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FP04CustomClass {

	public static void main(String[] args) {
		List<Course> list = Arrays.asList(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		// allMatch , noneMatch, anyMatch
		// allMatch
		boolean result = list.stream().allMatch(c -> c.getReviewScore() >= 98);
		System.out.println(result);

		// noneMatch
		System.out.println(list.stream().noneMatch(c -> c.getReviewScore() > 99));

		// anyMatch
		System.out.println(list.stream().anyMatch(c -> c.getReviewScore() > 98));

		// sort by number of students
		list.stream().sorted((a, b) -> a.getNoOfStudents().compareTo(b.getNoOfStudents())).forEach(System.out::println);

		System.out.println("-------------------------------------------------------------------------------------");
		// sort by nuber fo students and higher reover score if both have same students

		List<Course> cLit = list.stream().sorted((a, b) -> {
			if (a.getNoOfStudents().equals(b.getNoOfStudents())) {
				return b.getReviewScore().compareTo(a.getReviewScore());
			}
			return b.getNoOfStudents().compareTo(a.getNoOfStudents());

		}).collect(Collectors.toList());
		System.out.println(cLit);

		System.out.println("-----------------------------------------");

		// limit
		List<Course> sList = list.stream().sorted((a, b) -> {
			if (a.getNoOfStudents().equals(b.getNoOfStudents())) {
				return b.getReviewScore().compareTo(a.getReviewScore());
			}
			return b.getNoOfStudents().compareTo(a.getNoOfStudents());

		}).limit(5).collect(Collectors.toList());
		System.out.println(sList);

		// skip
		List<Course> list1 = list.stream().sorted((a, b) -> {
			if (a.getNoOfStudents().equals(b.getNoOfStudents())) {
				return b.getReviewScore().compareTo(a.getReviewScore());
			}
			return b.getNoOfStudents().compareTo(a.getNoOfStudents());

		}).skip(5).collect(Collectors.toList());
		System.out.println(list1);

		System.out.println("---------------------------------------------------------");

		System.out.println(list);

		Course c = list.stream().max((a, b) -> {
			if (a.getNoOfStudents().equals(b.getNoOfStudents())) {
				return a.getReviewScore().compareTo(b.getReviewScore());
			}
			return a.getNoOfStudents().compareTo(b.getNoOfStudents());

		}).get();
		System.out.println(c);

		Course c1 = list.stream().min((a, b) -> {
			if (a.getNoOfStudents().equals(b.getNoOfStudents())) {
				return a.getReviewScore().compareTo(b.getReviewScore());
			}
			return a.getNoOfStudents().compareTo(b.getNoOfStudents());

		}).get();
		System.out.println(c1);

		System.out.println(list.stream().filter(C -> C.getReviewScore() <= 97).findFirst());

		System.out.println(list.stream().filter(C -> C.getReviewScore() <= 97).findAny());

		System.out
				.println(list.stream().filter(x -> x.getReviewScore() > 95).mapToInt(cc -> cc.getNoOfStudents()).sum());

		System.out.println(
				list.stream().filter(x -> x.getReviewScore() > 95).mapToInt(cc -> cc.getNoOfStudents()).average());

		System.out.println(
				list.stream().filter(x -> x.getReviewScore() > 95).mapToInt(cc -> cc.getNoOfStudents()).count());

		// groupby

		// Function<Course, String> classifier = (Course cour) -> cour.getCategory();
		Map<String, List<Course>> map = list.stream().collect(Collectors.groupingBy(t -> t.getCategory()));
		System.out.println(map);
		// {Cloud=[AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91],
		// FullStack=[FullStack:14000:91],
		// Microservices=[API:22000:97, Microservices:25000:96],
		// Framework=[Spring:20000:98, Spring Boot:18000:95]}

		Set<String> keySet = list.stream().collect(() -> new HashSet<String>(),
				(Set<String> set, Course sub) -> set.add(sub.getCategory()), Set::addAll);

		System.out.println(keySet);

		Map<String, Long> map1 = list.stream()
				.collect(Collectors.groupingBy(t -> t.getCategory(), Collectors.counting()));
		System.out.println(map1);

		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
		// System.out.println(stream.reduce(0, (a, b) -> Integer.sum(a, b)));
		System.out.println(stream.reduce(0, Integer::sum));

		int num[] = { 2, 3, 5, 6 };
		IntStream stream2 = Arrays.stream(num);

		stream2 = IntStream.range(0, 10);
		System.out.println(stream2.sum());

		System.out.println(IntStream.iterate(2, a -> a + 2).limit(10).peek(System.out::println).sum());
		System.err.println("---------------------------");
		IntStream.iterate(2, a -> 2 * a).limit(10).forEach(System.out::println);

		// displaying large values
		BigInteger a = LongStream.rangeClosed(1, 50).mapToObj(va -> BigInteger.valueOf(va)).reduce(BigInteger.ONE,
				(x1, y1) -> x1.multiply(y1));
		System.out.println(a);

		System.err.println("------------------------------------------------------------------------------");
		list = Arrays.asList(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));

		String s = list.stream().map(course -> course.getName()).peek(System.out::println).reduce(new String(),
				(res, str) -> res.concat("," + str));

		System.out.println(s.subSequence(1, s.length()));

		System.err.println("------------------------------------------------------------------------------");
		List<String> strList = list.stream().map(c4 -> c4.getName()).collect(Collectors.toList());
		System.out.println(strList);

		List<String> strListCllected = strList.stream().map(str -> str.split("")).flatMap(arr -> Arrays.stream(arr))
				.collect(Collectors.toList());
		System.out.println(strListCllected);

		List<String> strListCllectedDistinct = strList.stream().map(str -> str.split(""))
				.flatMap(arr -> Arrays.stream(arr)).distinct().collect(Collectors.toList());
		System.out.println(strListCllectedDistinct);

		List<String> strList1 = list.stream().map(c4 -> c4.getName()).collect(Collectors.toList());

		System.out.println(strList.stream().flatMap(c4 -> strList1.stream().map(c5 -> Arrays.asList(c5, c4)))
				.collect(Collectors.toList()));

		// remove [str1,str1] -- same couerse pair
		System.err.println("------------------------------------------------------------------------------");
		System.out.println(
				strList.stream().flatMap(c4 -> strList1.stream().map(c5 -> Arrays.asList(c5, c4)).filter(l1 -> {
					if (!l1.get(0).equals(l1.get(1)))
						return true;
					return false;

				})).collect(Collectors.toList()));

		//

		// get only the pairs with same length
		System.err.println("------------------------------------------------------------------------------");
		System.out.println(
				strList.stream().flatMap(c4 -> strList1.stream().map(c5 -> Arrays.asList(c5, c4)).filter(l1 -> {
					if (l1.get(0).length() == l1.get(1).length()) {
						if (!l1.get(0).equals(l1.get(1)))
							return true;
					}
					return false;

				})).collect(Collectors.toList()));

		// or
		System.out.println(strList.stream().flatMap(c4 -> strList1.stream().filter(c6 -> c6.length() == c4.length())
				.map(c5 -> Arrays.asList(c5, c4)).filter(l1 -> {
					if (!l1.get(0).equals(l1.get(1)))
						return true;
					return false;

				})).collect(Collectors.toList()));

		System.err.println("=====================================================================================");

		System.out.println(strList);
		System.out.println(strList.stream().peek(System.out::println).filter(str -> str.length() > 11)
				.peek(System.out::println).map(str -> str.toUpperCase()).peek(System.out::println).findFirst().get());

		strList = list.stream().map(c4 -> c4.getName()).collect(Collectors.toList());
		System.out.println(strList);

		 strList.replaceAll(str -> str.toUpperCase());
		 System.out.println(strList);

		 strList.removeIf(str -> str.length() <6 );
		System.out.println(strList);

	}

}

class Course {
	private String name;
	private String category;
	private Integer reviewScore;
	private Integer noOfStudents;

	public Course(String name, String category, Integer reviewScore, Integer noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(Integer reviewScore) {
		this.reviewScore = reviewScore;
	}

	public Integer getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(Integer noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}