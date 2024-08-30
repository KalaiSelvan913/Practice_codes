import java.util.*;


public class Decimal_Binary {
	
	public static void DecimaltoBinary(int n){
		int i = 0, num = n;
		int temp[]=new int[10];
		while(n>0){
			temp[i++]=n%2;
			n = n/2;
		}
		System.out.print("Binary of "+num+" is ");
		for(int j = i-1;  j>=0; j--){
			System.out.print(temp[j]);
		}
		System.out.println();
		
	}
	// Converting to Binary number using "Stack" DataType
	public static void Dec2Bin(int n){
		int rem;
		Stack<Integer>stk = new Stack<Integer>();
		while(n!=0){
			rem=n%2;
			stk.push(rem);
			n=n/2;
		}
		System.out.print("Binary Value using 'Stack' Datatype : ");
		while(!stk.isEmpty()){
			System.out.print(stk.pop());
		} 
	}
	
	//Driver Code
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Decimal number : ");
		int dec = in.nextInt();
		DecimaltoBinary(dec);
		Dec2Bin(dec);
		
	}

}


//	OUTPUT:
//		
//		Enter the Decimal number : 
//			25
//			Binary of 25 is 11001
//			Binary Value using 'Stack' Datatype : 11001
		
