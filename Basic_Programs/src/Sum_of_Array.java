import java.util.*;
import java.lang.*;


public class Sum_of_Array {

	public static void main(String[] args) {
		
		int a=0,j;
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the limit of array: ");
		int n=in.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter The Number of Element: ");
		
		for(int i=0; i<n; i++){
		 arr[i] = in.nextInt();
		}
		
		for(j=0; j<n; j++){
			a=a+arr[j];
		}
		
		System.out.println("Sum of the Array "+Arrays.toString(arr)+" is "+a);
		
	}

}

//OUTPUT:
//	Enter the limit of array: 5
//	Enter The Number of Element: 
//	20
//	15
//	5
//	18
//	11
//	Sum of the Array [20, 15, 5, 18, 11] is 69

