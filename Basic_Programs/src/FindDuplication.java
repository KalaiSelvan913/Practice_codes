import java.util.*;
import java.lang.*;
import java.io.*;

public class FindDuplication {
		
	public static int removeduplicate(int a[], int n){
		if(n==0 || n==1){
			return n;
		}
		int temp[] = new int [n];
		int j=0;
		for(int i =0; i<n-1; i++){
			if(a[i]!=a[i+1]){
				
				temp[j++] = a[i];
				
			}
		}
		temp[j++]=a[n-1];
		for(int i = 0; i<j; i++){
			a[i] = temp[i];
		}
		return j;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Limit : ");
		int n = in.nextInt();
		int a[]= new int[n];
		System.out.print("Enter the element for array : ");
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		System.out.println("Current Array : "+Arrays.toString(a));
		Arrays.sort(a);
		
		
		n = removeduplicate(a, n);
		
		System.out.print("Changed Array : ");
		for(int i=0; i<n; i++){
			System.out.print(a[i]+" ");
		}
	}

}



//	OUTPUT:
//		
//		Enter the Limit : 
//			5
//			Enter the element for array : 1
//			2
//			1
//			3
//			2
//			Current Array : [1, 2, 1, 3, 2]
//			Changed Array : 1 2 3 
