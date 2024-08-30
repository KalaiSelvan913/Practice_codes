import java.util.*;
import java.lang.*;
import java.io.*;


public class LowerCase {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the String : ");
		
		StringBuilder sb = new StringBuilder( in.nextLine());
		
		for(int i = 0; i<sb.length(); i++){
			if((sb.charAt(i)>=65) && (sb.charAt(i)<=90)){
				int c = (int)sb.charAt(i) + 32;
				sb.setCharAt(i, (char)c);
				
			}
		}
		System.out.println("Lower Case : "+sb);
	}

}


//	OUTPUT:
//		
//		Enter the String : KALAISELVAN
//		Lower Case : kalaiselvan
		