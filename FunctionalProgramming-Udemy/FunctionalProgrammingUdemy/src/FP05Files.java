import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.xml.transform.stream.StreamSource;

public class FP05Files {

	public static void main(String[] args) throws Exception {

		List<String> collect = Files.lines(Paths.get("file.txt")).map(l -> l.split(" "))
				.flatMap(arr -> Arrays.stream(arr)).distinct().collect(Collectors.toList());
		
		System.out.println(collect);
		/*yashas
		samaga
		malathi
		samaga
		krishnamoorthy
		samaga
		rani
		tejus
*/
	}

}
