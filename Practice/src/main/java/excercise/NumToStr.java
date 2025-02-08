package excercise;

import java.util.Scanner;

public class NumToStr {
	private static final String[] units = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
	private static final String[] teens = {"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	private static final String[] tens = {"","Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninty"};
	
	private static final String[] newUnits = {"","Thousand", "Million","Billion","Trillion"};
	private static final String[] belowTwenty = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
			"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	private static final String[] newTens = {"","","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Number to convert : ");
		int num = in.nextInt();
		System.out.println(NumberToString(num));
		System.out.println("Enter New Number");
		int newNum = in.nextInt();
		System.out.println(convertNumberToWord(newNum));
		in.close();
	}
	
	
	private static String NumberToString(int num) {
		if(num==0)
			return "Zero";
		if(num<1 || num>9999) {
			System.out.println("Number Should be between 1 to 9999");
			return "NA";
		}
		return NumberToStringHelper(num).trim();
	}
	
	private static String NumberToStringHelper(int num) {
		if(num<10) {
			return units[num];
		}else if(num<20) {
			if(num-10 == 0)
				return tens[1];
			return teens[num-10];
		}else if(num<100) {
			return tens[num/10]+" "+NumberToStringHelper(num%10);
		}else if(num<1000) {
			return units[num/100]+" Hundred "+NumberToStringHelper(num%100);
		}else {
			return units[num/1000]+" Thousand "+NumberToStringHelper(num%1000);
		}
	}
	
	 private static String convertBelowThousand(long number) {
	        if (number == 0) {
	            return "";
	        } else if (number < 20) {
	            return belowTwenty[(int) number] + " ";
	        } else if (number < 100) {
	            return newTens[(int) (number / 10)] + " " + convertBelowThousand(number % 10);
	        } else {
	            return belowTwenty[(int) (number / 100)] + " Hundred " + convertBelowThousand(number % 100);
	        }
	    }
	 
	 private static String convertNumberToWord(long num) {
		 if(num == 0)
			 return "Zero";
		 int index = 0;
		 String words = "";
		 
		 do {
			 long part = num%1000;
			 if(part != 0) {
				 String partWords = convertBelowThousand(part);
				 words = partWords+" "+newUnits[index]+" "+words;
			 }
			 index++;
			 num /= 1000;
		 }while(num>0);
		 return words.trim();
	 }
	
	
	

}
