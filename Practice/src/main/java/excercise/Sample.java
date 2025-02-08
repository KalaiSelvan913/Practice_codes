package excercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Sample {
	
	public static void main (String[] args) {
		String inputSentence = "dto1 employ0ee 2list 3is empt5y n4ot";
		String x = "employee dto list is not empty";
		
		
		String sort = sortSentence(inputSentence);
		
		System.out.println(sort);
		System.out.println(changeFirstWord(x));
	
		int n= 372;
		if(armCheck(n))
			System.out.println("True : "+n);
		else 
			System.out.println("False : "+n);
		n=2;
		if(isPrime(n))
			System.out.println("P : "+n);
		else
			System.out.println("NP: "+n);
		
		bin(12);
		System.out.println(Integer.toBinaryString(12));
		
		System.out.println(hex(125));
		System.out.println(Integer.toHexString(125));
		
		System.out.println(fact(5));
		
		System.out.println(fib(10));
		
		if(isAnagram("Madam", "madam"))
			System.out.println("anagram");
		else
			System.out.println("not anagram");
		
		
		
		
		 n=3;
		System.out.println("*");
		for(int i=1; i<=n; i++) {
			System.out.print("*");
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			for(int j=i-1; j>0; j--) {
				System.out.print(j);
			}
			System.out.println("*");
		}
		for(int i=n-1; i>0; i--) {
			System.out.print("*");
			for(int j=1; j<=i; j++) {
				System.out.print(j);
			}
			for(int j=i-1; j>0; j--) {
				System.out.print(j);
			}
			System.out.println("*");
		}
		System.out.println("*");
		System.out.println();
		
		n=5;
		
		for(int i=1; i<n; i++) {
			for(int j=i; j<=n; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<i; j++) {
				System.out.print("*");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(" ");
			}
			for(int j=i; j<n; j++) {
				System.out.print("*");
			}
			for(int j=i; j<=n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		n=5;
		int p=1;
		
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<i; j++) {
				System.out.print(p);
			}
			for(int j=1; j<=i; j++) {
				System.out.print(p );
			}
			System.out.println();
			p++;
		}
		n=5;
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		int[] num = {-10, -3, -5, -6, -20};
		
		TripletResponse result = tripletmuli(num);
		
		System.out.println("Multi : "+result.product);
		System.out.println("num : "+ Arrays.toString(result.numbers));	
		
		
		pascalTriangle(3);
		
		printButterfly(6);
		
		decreasePyramid(6);
		
	}
	
	private static String remove(String input) {
		return input.replaceAll("\\d", "");
	}
	
	private static String sortSentence(String input) {	
		return Arrays.stream(input.split(" "))
				.sorted(Comparator.comparingInt(Sample::getNumberFromWord))
				.map(Sample::remove).collect(Collectors.joining(" "));
	}
	
	
	private static int getNumberFromWord(String word)  {
		return word.chars().filter(Character::isDigit)
				.map(Character::getNumericValue)
				.reduce((x, y) -> y)
				.orElse(0);
	}
	
	private static String changeFirstWord(String input) {
//		return Arrays.stream(input.split(" ")).map(StringUtils::capitalize).collect(Collectors.joining(" "));
//		return Arrays.stream(input.split(" ")).map(Sample::firstLetter).collect(Collectors.joining(" "));
		return Stream.of(input.split(" ")).map(Sample::firstLetter).collect(Collectors.joining(" "));
	}
	
	private static String firstLetter(String str) {
		return str.substring(0,1).toUpperCase()+str.substring(1);
	}
	
	private static boolean armCheck(int n) {
		int size = String.valueOf(n).length();
		return String.valueOf(n)
				.chars()
				.map(Character::getNumericValue)
				.boxed()
				.mapToInt(d -> (int)Math.pow(d, size)).sum() == n;
	}
	
	private static boolean isPrime(int n) {
		return !IntStream.rangeClosed(2, n/2).anyMatch(i -> n%i == 0);
	}
	
	private static void bin(int n) {
		int i = 0;
		int[] temp = new int[10];
		
		while(n>0) {
			temp[i++] = n%2;
			n= n/2;
		}
		
		for (int j = i-1; j>=0; j--) {
			System.out.print(temp[j]);
		}
		System.out.println();
	}
	
	private static String hex(int n) {
		int rem = 0;
		String[] hexdec = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		StringBuilder hex = new StringBuilder();
		while(n>0) {
			rem = n%16;
			hex.append(hexdec[rem]);
			n = n/16;
		}
		return hex.reverse().toString();
	}
	
	private static int fact(int n) {
		if(n==0)
			return 1;
		return n*fact(n-1);
	}
	
	private static List<Integer> fib(int n){
		return Stream.iterate(new int[] {0,1}, f -> new int[] {f[1], f[0]+f[1]})
				.limit(n)
				.map(f ->f[0])
				.collect(Collectors.toList());
	}
	
	private static boolean isAnagram(String w1, String w2) {
		if(w1.length() != w2.length())
			return false;
		char[] a = w1.toLowerCase().replaceAll("\\s", "").toCharArray();
		char[] b = w2.toLowerCase().replaceAll("\\s", "").toCharArray();
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		return Arrays.equals(a, b);
	}
	
	private static TripletResponse tripletmuli(int[] arr){
		int n = arr.length;
		
		Arrays.sort(arr);
		
		int maxProd = arr[n-1] * arr[n-2] * arr[n-3];
		int[] num1 = {arr[n-1], arr[n-2], arr[n-3]};
		
		int max1Prod = arr[0] * arr[1] * arr[n-1];
		int[] num2 = {arr[0], arr[1], arr[n-1]};
		
		return (maxProd > max1Prod) ? new TripletResponse(maxProd, num1) : new TripletResponse(max1Prod, num2);
	}
	
	private static class TripletResponse{
		int product;
		int[] numbers;
		
		TripletResponse(int product, int[] numbers){
			this.product = product;
			this.numbers = numbers;
		}
	}
	
	/*
	1 
   1 1 
  1 2 1 
 1 3 3 1
	*/
	
	private static void pascalTriangle(int n) {
		
		for(int i =0; i<n; i++) {
			for(int j=0; j< n-1; j++) {
				System.out.print(" ");
			}
			int number = 1;
			for(int j=0; j<=i; j++) {
				System.out.print(number+" ");
				number = number * (i-j)/(j+1);
			}
			System.out.println();
		}
	}
	
	private static void printButterfly(int n) {
		for(int i=1; i<=n; i++ ) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
//			int space = 2*(n-i);
//			for(int j=1; j<=space; j++) {
//				System.out.print(" ");
//			}
			for(int j=i; j<n; j++) {
				System.out.print(" ");
			}
			for(int j=i; j<n; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				System.out.print("*");
			}
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			for(int j=i; j<=n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	private static void decreasePyramid(int n) {
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	
	
		
}



