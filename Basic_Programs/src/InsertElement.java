import java.util.*;
import java.lang.*;

public class InsertElement {

	public static void main(String[] args) {
		int index, value;
		
		
		int a[] = {10,20,30,40,50,60,70,80,90,100};
		index = 2;
		value= 55;
		System.out.println("Before Insert "+Arrays.toString(a));
		
		for(int i = a.length-1; i>index; i--){
			a[i]=a[i - 1];
		}
		a[index] = value;
		System.out.println("After Insert "+Arrays.toString(a));
		
		int b[]={1,2,5,5,6,6,7,2};
		System.out.println("Elements in the arrays are : "+Arrays.toString(b));
		System.out.print("Duplicate Elements in the arrays are : ");
		for(int j =0; j<b.length-1; j++){
			for(int k = j+1; k < b.length; k++){
				if((b[j]==b[k]) && (j != k)){
					System.out.print(b[k]+" ");
				}
				
			}
		}
		
	}

}


//	OUTPUT:
//		
//				Before Insert [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]
//				After Insert [10, 20, 55, 30, 40, 50, 60, 70, 80, 90]
//				Elements in the arrays are : [1, 2, 5, 5, 6, 6, 7, 2]
//				Duplicate Elements in the arrays are : 2 5 6 
//		
