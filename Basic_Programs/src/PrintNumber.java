import java.util.*;
public class PrintNumber {
	
	public static void print(int n){
		
		int digit1, digit2;
		String a[]={"","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety","Hundred"};
		String b[]={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Tweleve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
		if(n<=1||n>=101){
			System.out.println("You Have Enter the Wrong Number ");
		}
		if(n>=1 && n<=19){
			System.out.println(b[n]);
		}
		if(n>=20 && n<=100){
			digit1 = n/10;
			digit2 = n%10;
			System.out.println(a[digit1]+" "+b[digit2]);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the Number : ");
		int n = in.nextInt();
		
		
		print(n);
	}

}

//OUTPUT:
//		Enter the Number : 
//		25
//		Twenty Five
