package excercise;

import java.util.Arrays;
import java.util.List;

public class AverageFromObject {
	
	public static void main(String[] args) {
		
		List<MyObject> myObject = Arrays.asList(
				new MyObject(10.0),
				new MyObject(25.0),
				new MyObject(45.0),
				new MyObject(32.0),
				new MyObject(18.0),
				new MyObject(67.0)
				);
		
		double average = myObject.stream().mapToDouble(MyObject::getNumericField).average().orElse(0.0);
		System.out.println(average);
	}

}

class MyObject {
	private double numericField;
	
	MyObject(double numericField){
		this.numericField = numericField;
	}
	
	public double getNumericField() {
		return numericField;
	}
}
