import java.util.*;


public class PerfectNumber {
	
	
	static void Perfect(int n){
		
		int sum=0;
		for(int i =1; i<n; i++){
			if(n%i == 0){
				sum+=i;
			}
		}
		if(sum == n)
			System.out.print(n+" is a Perfect Number ");
		else
			System.out.print(n+" is Not a Perfect Number ");
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number : ");
		int n = in.nextInt();
		
		Perfect(n);
		
	}

}

//OUTPUT:	
//	Enter the Number : 6
//	6 is a Perfect Number 
