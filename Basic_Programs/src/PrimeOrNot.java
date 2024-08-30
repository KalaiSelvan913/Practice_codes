import java.util.*;
import java.lang.*;

public class PrimeOrNot {
	
	
	public static void primeCheck(int n){
		int f=0;
		
		for(int i=1; i<=n; i++){
			if(n%i == 0){
				f++;
			}
		}
		if(f == 2)
			System.out.println(n+" is Prime Number ");
		else
			System.out.println(n+" is Not Prime Number ");
	}

	static void prime_Numbers(int num ){
		int f=0;
		for(int n=1; n<=num; n++){
			for(int i=1; i<=n; i++){
				if(n%i == 0){
					f++;
				}
			}
			if(f==2){
				System.out.println(n+" is a Prime Number ");
			}
			f = 0;
		}
		
	}
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number to Find Prime : ");
		int n = in.nextInt();
		PrimeOrNot P = new PrimeOrNot();
		P.primeCheck(n);
		System.out.print("Enter the limit : ");
		int lim = in.nextInt();
		P.prime_Numbers(lim);
	}

}

//OUTPUT:
//	Enter the Number to Find Prime : 21
//	21 is Not Prime Number 
//	Enter the limit : 5
//	2 is a Prime Number 
//	3 is a Prime Number 
//	5 is a Prime Number 
