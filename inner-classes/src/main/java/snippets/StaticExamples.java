package snippets;

public class StaticExamples {
	
	private static class StaticTest {
		public void test() {
			System.out.println("Test");
		}
	}
	
	public static void main(String[] args) {
		new StaticTest().test();
	}

}
