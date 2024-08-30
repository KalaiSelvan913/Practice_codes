import java.util.*;



public class AmstrongNumbers {

	public static boolean isArmstrong(int n){
		int temp,last=0,digits=0,sum=0;
		temp = n;
		
		while(temp>0){
			temp = temp/10;
			digits++;
		}
		
		temp=n;
		while(temp>0){
			last = temp%10;
			sum+= (Math.pow(last, digits));
			temp = temp/10;
		}
		if(sum == n)
			return true;
		else
			return false;
	}
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the limit  : ");
		int n = in.nextInt();
		System.out.println("Amstrong Number up to "+n+" are : ");
		for(int i=0; i<=n; i++){
			if(isArmstrong(i)){
				System.out.print(i+",");
			}
		}
		System.out.println();
		System.out.println("Enter the Number to Check : ");
		int num = in.nextInt();
		if(isArmstrong(num))
			System.out.println("Number "+num+" is Amstrong");
		else
			System.out.println("Number "+num+" is Not Amstrong ");
		
	}

}


//	Output:
//		
//		Enter the limit  : 5
//		Amstrong Number up to 5 are : 
//		0,1,2,3,4,5,
//		Enter the Number to Check : 
//		25
//		Number 25 is Not Amstrong 
		
