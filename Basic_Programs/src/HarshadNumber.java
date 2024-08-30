import java.util.*;


/* Harshad Number or Niven Number is a number which is divisible by the sum of digits.
 * if 21 means 2+1 =3 is divisible by the actual number 21/3 =7 so it is Harshad number
*/
public class HarshadNumber {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n =in.nextInt();
		int sum = sumOfDigit(n);
		if(n%sum == 0)
			System.out.println(n+" is Harshad or Niven Number");
		else
			System.out.println(n+" is Not Harshad or Niven Number ");

	}
	public static int sumOfDigit(int n){
		if(n==0)
			return 0;
		
		return n%2+sumOfDigit(n/10);
	}

}


//	OUTPUT:
//		
//		Enter the Number : 
//			5
//			5 is Harshad or Niven Number