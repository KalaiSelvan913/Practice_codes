import java.util.*;
public class Decimal_HexaDecimal {


	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Decimal Number : ");
		int dec = in.nextInt();
		System.out.println("HexaDecimal of "+dec+" is "+Dec2Hex(dec));
	}
	
	public static String Dec2Hex(int n){
		int rem;
		String hex="";
		char hexChars[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		while(n>0){
			rem = n%16;
			hex = hexChars[rem]+hex;
			n = n/16;
		}
		return hex;
	}

}

//	OUTPUT:
//		
//		Enter the Decimal Number : 
//			25
//			HexaDecimal of 25 is 19