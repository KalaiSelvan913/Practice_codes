package excercise;

public class TestNod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RamNod rnode1= new RamNod(10);
		RamNod rNode2= new RamNod(20);
		
		rnode1.next= rNode2;
		rNode2.prev= rnode1;
		
		

	}

}
