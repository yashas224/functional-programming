
public class TypeInference {

	public static void main(String[] args) {

		printLambda(s -> s.length());
	}

	public static void printLambda(StringLengthLambda lambda) {
		System.out.println(lambda.method("yashas samaga"));
	}

}

interface StringLengthLambda {
	int method(String s);
}
