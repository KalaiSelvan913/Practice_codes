import java.lang.*;
import java.io.*;
import java.util.*;

public class CapitaliseEach {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Orginal String : ");
		StringBuilder sb = new StringBuilder(in.nextLine());
	
		
		if(sb.charAt(0)>=97 && sb.charAt(0)<=122){
			
			int c = (int)sb.charAt(0)-32;
			sb.setCharAt(0, (char)c);
			
		}
		for(int i=1; i<sb.length(); i++){
			if(sb.charAt(i)==32){
				i++;
				if(sb.charAt(i)>=97&&sb.charAt(i)<=122){
					int c = (int)sb.charAt(i)-32;
					sb.setCharAt(i, (char)c);
				}
			}else{
					if(sb.charAt(i)>=65 && sb.charAt(i)<=90){
						int c = (int)sb.charAt(i)+32;
						sb.setCharAt(i, (char)c);
						
					}
				}
					
			}
		System.out.print("Capitalized String : "+sb);
		}
}


//	Output: 
//		
//		Orginal String : kalai selvan is working
//		Capitalized String : Kalai Selvan Is Working
		
	


