import java.util.*;
import java.lang.*;

public class FactorNumbers {

	
	public static void Fact(int n){
		System.out.print("Factors of "+n+" are : ");
		for(int i = 1; i<=n; i++){
			if(n%i == 0){
				System.out.print(i+" ");
			}
		}
		
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number to Find Factor : ");
		int n = in.nextInt();
		
		FactorNumbers fn = new FactorNumbers();
		fn.Fact(n);
	}

}

//	OUTPUT:
//		
//		Enter the Number to Find Factor : 8
//		Factors of 8 are : 1 2 4 8 
