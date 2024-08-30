import java.util.*;
import java.lang.*;
import java.io.*;

public class Toggle {

	public static void main(String[] args) {
		Scanner in =  new Scanner(System.in);
		System.out.print("Enter the String : ");
		StringBuilder sb = new StringBuilder(in.nextLine());
		
		for(int i = 0; i<sb.length(); i++){
			if(sb.charAt(i)>=65 && sb.charAt(i)<=90){
				int c = (int)sb.charAt(i) + 32;
				sb.setCharAt(i, (char)c);
			}else if(sb.charAt(i)>=97 && sb.charAt(i)<=122){
				int c = (int)sb.charAt(i) - 32 ;
				sb.setCharAt(i, (char)c);
			}
		}
		System.out.print("Toggle string : "+sb);
	}

}

//OUTPUT:
//	Enter the String : ToGgle EXamPle
//	Toggle string : tOgGLE exAMpLE