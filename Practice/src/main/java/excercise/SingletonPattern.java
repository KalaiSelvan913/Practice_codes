package excercise;

public class SingletonPattern {
	
	private SingletonPattern() {}
	
	private static class BillPughSingleton{
		private static final SingletonPattern instance = new SingletonPattern();
	}
	
	public static SingletonPattern getInstance() {
		return BillPughSingleton.instance;
	}
	
	String status = "SUCCESS";
}

class tester {
	public static void main(String[] args) {
		SingletonPattern sp = SingletonPattern.getInstance();
		System.out.println(sp.status);
		
	}
}

