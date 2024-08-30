import java.util.*;
public class LeapOrNot {

	// Driver Code
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Year: ");
		int Year = in.nextInt();
		if(isLeap(Year))
			System.out.println(Year+" is Leap Year ");
		else
			System.out.println(Year+" is Not a Leap Year ");
		
	}
	
	public static boolean isLeap(int n){
		if((n%4 == 0)&&(n%100 !=0)|| (n%400 ==0))
			return true;
		return false;
	}
}


//	OUTPUT:
//		
//		Enter the Year: 
//			2022
//			2022 is Not a Leap Year 

		