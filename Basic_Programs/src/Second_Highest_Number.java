import java.util.*;
import java.lang.*;


public class Second_Highest_Number {
	

	public static int getSecondLargest(int a[], int num){
		
		int temp;
		for(int i =0; i<num; i++){
			for (int j = i+1; j<num; j++){
				if(a[i]>a[j]){
					temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		return a[num-2];
		
	}
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the limit of array: ");
		int n=in.nextInt();
		
		int arr[] = new int[n];
		System.out.println("Enter The Number of Element: ");
		
		for(int i=0; i<n; i++){
		 arr[i] = in.nextInt();
		}
		System.out.println("Array : "+Arrays.toString(arr));
		
		
		System.out.println("The Second Highest Number in Array "+getSecondLargest(arr,n));
	}

}

//OUTPUT:
//	Enter the limit of array: 5
//	Enter The Number of Element: 
//	25
//	15
//	20
//	18
//	5
//	Array : [25, 15, 20, 18, 5]
//	The Second Highest Number in Array 20
