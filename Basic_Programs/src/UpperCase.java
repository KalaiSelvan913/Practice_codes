import java.util.*;
import java.lang.*;
import java.io.*;

public class UpperCase {

	public static void main(String[] args) {
		
		StringBuilder a = new StringBuilder("hi everyone");
		System.out.println("original String : "+a);
		for(int i =0; i<a.length(); i++){
			if(a.charAt(i)>=97 && a.charAt(i)<=122){
				int c = (int)a.charAt(i)-32;
				a.setCharAt(i, (char)c);
			}
		}
		System.out.println("Uppercase Outpur : "+a);
		
	}

}


//OUTPUT:
//	original String : hi everyone
//	Uppercase Outpur : HI EVERYONE
