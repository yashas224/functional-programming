package unit3;

public class MethodReferemceExample {

	public static void main(String[] args) {
		// both are exactly same
		// new Thread(() -> printMessage()).start();

		new Thread(MethodReferemceExample::printMessage).start();
		// MethodReferemceExample::printMessage === ()-> printMessage();

	}

	private static void printMessage() {
		System.out.println("Hello message");
	}
}
