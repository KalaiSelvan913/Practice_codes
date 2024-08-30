import java.util.*;

public class MergeAndSort {

	public static int[] MergeArray(int arr1[], int arr2[]){
		int Merge[]=new int [arr1.length+arr2.length];
		int i=0, j=0,k=0;
		while(i<arr1.length){
			Merge[k] = arr1[i];
			i++;
			k++;
		}
		while(j<arr2.length){
			Merge[k]=arr2[j];
			j++;
			k++;
		}
		Arrays.sort(Merge);
		return Merge;
	}

	public static void main(String[] args) {
		
		int arr1[]={1,2,3,6,5,4};
		int arr2[]={7,9,8,11,12,10};
		int arrMerge[]= MergeArray(arr1, arr2);
		
		System.out.println("Array 1 : "+Arrays.toString(arr1));
		System.out.println("Array 2 : "+Arrays.toString(arr2));
		System.out.println("Merged Array : "+Arrays.toString(arrMerge));
	}

}

//	OUTPUT:
//		
//				Array 1 : [1, 2, 3, 6, 5, 4]
//				Array 2 : [7, 9, 8, 11, 12, 10]
//				Merged Array : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
