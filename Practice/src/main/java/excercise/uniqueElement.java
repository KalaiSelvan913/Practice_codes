package excercise;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class uniqueElement {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
		
		int[] arr = {1,2,1,4,4};
		System.out.println(findUniqueElement(arr));
//		System.out.println("Enter Numbers : ");
//		int y = in.nextInt();
//		System.out.println(isTrue(y));
//		int n = in.nextInt();
//		System.out.println(getStatement(n));
////		System.out.println(findUniqueElement(arr));
//		in.close();
	}
	
	private static int findUniqueElement(int[] arr) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		
		for(int num : arr) 
			frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
		
		for(Map.Entry<Integer, Integer> checkMap : frequencyMap.entrySet()) {
			if(checkMap.getValue() == 1)
				return checkMap.getKey();
		}
		throw new IllegalArgumentException("No Such Elements present");
	}
	
	private static boolean isTrue(int num) {
		return ((num%4 == 0) && (num%100 != 0 || num%400 == 0)) ? true : false;
	}
	
	private static String getStatement(int num) {
		return (num < 0)? "NEGATIVE" : ((num > 0) ? "POSITIVE" : "ZERO"); 
	}

}
