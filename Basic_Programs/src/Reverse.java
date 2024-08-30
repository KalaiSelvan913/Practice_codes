import java.util.*;
import java.lang.*;
import java.io.*;


public class Reverse {

	public static void main(String[] args) {
		
		//program to reverse a given string
		StringBuilder a = new StringBuilder("Hi My Name is kalaiselvan");
		System.out.println(a);
		StringBuilder b = new StringBuilder();
		for(int i=a.length()-1; i>=0; i--){
			b.append(a.charAt(i));
		}
		System.out.println(b);
	}

}


//OUTPUT:
//	Hi My Name is kalaiselvan
//	navlesialak si emaN yM iH
