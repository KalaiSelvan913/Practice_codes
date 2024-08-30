import java.util.*;


public class Fibonacci {
	
	public static void fib(int n){
		int a=-1, b=1, c;
		System.out.print("Fibonacci of "+n+" is ");
		for(int i=1; i<=n; i++){
		c = a+b;
		System.out.print(" "+c);
		a=b;
		b=c;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = in.nextInt();
		
		Fibonacci f = new Fibonacci();
		f.fib(n);
		
	}

}

//	OUTPUT:
//		
//		Enter the Number : 5
//		Fibonacci of 5 is  0 1 1 2 3
		
