
public class ClosureExample {

	public static void main(String[] args) {
		int j = 5;
		// j++;
		// doProcess(7, new Process() {
		// @Override
		// public void process(int i) {
		// System.out.println(i + j);
		//
		// }
		// });
		

		doProcess(5, i -> System.out.println(i + j));
	}

	public static void doProcess(int i, Process p) {
		p.process(i);
	}
}

interface Process {
	void process(int i);
}