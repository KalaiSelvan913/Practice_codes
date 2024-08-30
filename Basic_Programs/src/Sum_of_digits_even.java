import java.util.*;
import java.lang.*;


public class Sum_of_digits_even {

	public static int SumEven(int n){
		int sum = 0;
		if(n==0)
			return 0;
		while(n>0){
		if((n%10)%2==0){
			sum = sum + n%10;
		}
			n = n/10;
			
		}
		return sum;
	}
			
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = in.nextInt();
		System.out.println("Sum of the Even number :"+SumEven(n));
		
	}

}

//OUTPUT:
//	Enter the Number : 526485
//	Sum of the Even number :20
