import java.util.*;
public class OddOrEven {
	
	// Check Odd or Even without using Condition Statement 

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = in.nextInt();
		
		String[] trick = {"Even","Odd"};
		
		System.out.println("The Given Number "+n+" is "+trick[n%2]+" without using Condition statement ");
		
		// Check Odd or Even without Using Modulus or Division
		System.out.println("The Given Number "+n+" is "+trick[n&1]+" without using Modulus ");
		
		
	}

}

//	OUTPUT:
//		Enter the Number : 15
//		The Given Number 15 is Odd without using Condition statement 
//		The Given Number 15 is Odd without using Modulus 	
