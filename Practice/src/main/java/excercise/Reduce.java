package excercise;

import java.util.ArrayList;
import java.util.List;

public class Reduce {

	public static void main(String[] args) {
		
		
	List<Integer> obj = new ArrayList<>();
	
	/*obj.add(1);
	obj.add(2);
	obj.add(3);*/
	
	int obj1 = obj.stream().reduce(0, (a,b)-> a+b);
	
	System.out.println(obj1);

	}

}
