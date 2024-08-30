import java.util.*;


public class Factorial {
	
	public static int fac(int n){
		int i, fact = 1;
		for(i=1; i<=n; i++){
			 
			fact*=i;
		}
		return fact;
	}
	
	//Finding Factorial Using Recursion Method
	public static int getch(int n){
		if(n==0)
			return 1;
		else
			return n*getch(n-1);
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int n = in.nextInt();
		
		System.out.println("The Factorial of "+n+" is "+fac(n));
		System.out.println("Factorial Using Recursion Method : "+getch(n));
		

	}

}

//	OUTPUT:
//		
//		Enter the number : 5
//		The Factorial of 5 is 120
//		Factorial Using Recursion Method : 120
