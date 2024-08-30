import java.util.*;
import java.lang.*;


public class Reverse_Num {
	
	public static int Rev(int num){
		int reverse = 0, rem;
		
		while(num != 0){
			rem = num%10;
			reverse = (reverse*10)+rem;
			num = num/10;
		}
		return reverse;
	}

	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = in.nextInt();
		System.out.println("Reversed Numbers are : "+Rev(n));
	}

}

//OUTPUT:
//	Enter the Number : 562
//	Reversed Numbers are : 265
