import java.util.*;
import java.lang.*;
import java.io.*;

public class LargestNumber {

	public static void LargestSecond(int a[], int n){
		int large =0, second = 0, small=0;
		for(int i =0; i<n; i++){
			if(a[i]>large){
				second = large;
				large = a[i];
			}else if(a[i]>second){
				second = a[i];
			}else if (a[i]<small){
				small=a[i];
			}
		}
		System.out.println("Largest No of the array is "+large);
		System.out.println("Second Largest No of the array is "+second);
		System.out.println("Smallest No of the array is "+small);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Limit : ");
		int n = in.nextInt();
		int a[]=new int[n];
		System.out.println("Enter the element of array : ");
		for(int i =0; i<n; i++){
			a[i] = in.nextInt();
		}
		System.out.println("Current Array : "+Arrays.toString(a));
		LargestSecond(a, n);
	}

}


//	OUTPUT:
//		
//		Enter the Limit : 
//			5
//			Enter the element of array : 
//			20
//			21
//			10
//			25
//			16
//			Current Array : [20, 21, 10, 25, 16]
//			Largest No of the array is 25
//			Second Largest No of the array is 21
//			Smallest No of the array is 0

