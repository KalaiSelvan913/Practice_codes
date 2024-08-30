import java.util.*;
public class Palindrome {
	
	public static boolean isPalindrome(String str){
		int i = 0;
		int j = str.length()-1;
		while(i<j){
			if(str.charAt(i)!= str.charAt(j))
				return false;
			
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = in.nextLine();
		if(isPalindrome(str))
			System.out.println("Given String is Palindrome ");
		else
			System.out.println("Given String is Not Palindrome ");
		
	}

}

//OUTPUT:
//		Enter the String : 
//		MADAM
//		Given String is Palindrome 
