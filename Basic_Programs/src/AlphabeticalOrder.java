import java.util.*;



public class AlphabeticalOrder {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = in.nextLine();
		char chararry[]= str.toCharArray();
		Arrays.sort(chararry);
		System.out.println("Ordered Alphabets are : "+ new String(chararry));
		
	}

}

/*
 * Input :

 * Enter the String : kalai selvan is working
 * 
 * Output: 
 * Ordered Alphabets are : aaaegiiikkllnnorssvw
 */
		