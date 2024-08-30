import java.util.*;
public class MaximumOccurance {

	public static void main(String[] args) {
		String s = "simple string";
		int max =0;
		
		char c[]=s.toCharArray();
		String s1 = "";
		LinkedHashMap<Character, Integer>m=new LinkedHashMap<Character,Integer>();
		for(char c1 :c){
			if(!m.containsKey(c1)){
				m.put(c1,1);
			}
			else{
				m.put(c1,m.get(c1)+1);
				max++;
			}
		}
		for(Map.Entry<Character,Integer>m1:m.entrySet()){
			if(max==m1.getValue()){
				s1=s1+" "+m1.getKey();
			}
		}
		System.out.print(s1);
	}

}

//	OUTPUT:      s i
