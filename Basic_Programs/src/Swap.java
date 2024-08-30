import java.util.*;
import java.lang.*;


public class Swap {

	public static void main(String[] args) {
		int temp;
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the two numbers to swap : ");
		int a=in.nextInt();
		int b=in.nextInt();
		
		System.out.println("Befor Swaping the number : a = "+a+" b = "+b);
		 // without using temporary variable
		a = a + b;
		b = a - b;
		a = a - b;
		
		System.out.println("After Swaping without temporary variable : a = "+a+" b = "+b);
		

		temp = a;
		a = b;
		b = temp;
		
		System.out.println("After Swaping with temporary variable : a = "+a+" b = "+b);
		
	}

}

//OUTPUT:
//	Enter the two numbers to swap : 50
//	100
//	Befor Swaping the number : a = 50 b = 100
//	After Swaping without temporary variable : a = 100 b = 50
//	After Swaping with temporary variable : a = 50 b = 100
