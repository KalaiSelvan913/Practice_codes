import java.util.*;
public class SumOfDigits {
	
	public static int sum_of_digit(int n){
		if(n==0)
			return 0;
		else
			return((n%10) + sum_of_digit(n/10));
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = in.nextInt();
		int result = sum_of_digit(n);
		System.out.println("Sum of digits in "+n+" is "+result);
	}

}

//OUTPUT:
//	Enter the Number : 56724
//	Sum of digits in 56724 is 24