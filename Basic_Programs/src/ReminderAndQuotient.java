import java.util.*;
public class ReminderAndQuotient {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Dividend : ");
		int dividend = in.nextInt();
		System.out.println("Enter the Divisor : ");
		int divisor = in.nextInt();
		int quotient = 0;
		while(dividend >= divisor){
			dividend = dividend - divisor;
			quotient++;
		}
		
		System.out.println("Quotient is "+quotient);
		System.out.println("Reminder is "+dividend);
	}

}

//OUTPUT:
//		Enter the Dividend : 
//		25
//		Enter the Divisor : 
//		5
//		Quotient is 5
//		Reminder is 0
	
