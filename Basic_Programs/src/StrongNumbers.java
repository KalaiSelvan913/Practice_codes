import java.util.*;


public class StrongNumbers {
	
	
	static void Strong(int n){
		int rem, fact, sum=0;
		int orginal = n;	//145
		while(n>0){
			 rem = n%10;	// 5   4    1
			 fact = 1;
			 for(int i=1; i<=rem; i++){
				
				 fact*=i;  // 5!  4!   1!
			 }
			 sum+=fact;
			 n = n/10;
		}
		if(sum == orginal)
			System.out.print(orginal+" is a Strong Number ");
		else
			System.out.print(orginal+" is Not Strong Number ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the Number To Check Strong number or Not : ");
		int n = in.nextInt();
		
		Strong(n); //145
	}

}

//OUTPUT:
//	Enter the Number To Check Strong number or Not : 25
//	25 is Not Strong Number 
