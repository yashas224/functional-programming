
public class ReferenceExample {

	@Override
	public String toString() {
		return "ReferenceExample class ";
	}

	public static void main(String[] args) {

		ReferenceExample obj = new ReferenceExample();

		// annomyus inner clalss
		// obj.doProcess(5, new Process() {
		// @Override
		// public void process(int i) {
		// System.out.println("value is : " + i);
		// System.out.println(this);
		// this reference overides and points to the instance of object of anonymus
		// inner class
		// }
		//
		// @Override
		// public String toString() {
		// return " Anonymus inner class";
		// }
		// });

		// // lambda
		//
		// obj.doProcess(5, i -> {
		// System.out.println("value is : " + i);
		// // System.out.println(this); // this will not work in lambda's
		// });

		obj.execute();
	}

	public void doProcess(int i, Process p) {
		p.process(i);
	}

	// in lambdas "this" reference takes the properity from outside the lambda
	// exprssion
	public void execute() {
		doProcess(5, i -> {
			System.out.println("value is  -" + i);
			System.out.println(this);
		});
	}

}
