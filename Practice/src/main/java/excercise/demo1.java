package excercise;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    	int size = arr.size();
    	double posNumber = 0;
    	double negNumber = 0;
    	double zeroNum = 0;
    	for(int num : arr) {
    		if(num>0) {
    			posNumber++;
    		}else if(num<0) { 
    			negNumber++;
    		}else {
    			zeroNum++;
    		}
    	}
    	System.out.println(String.format("%.5f", posNumber/size));
    	System.out.println(String.format("%.5f", negNumber/size));
    	System.out.println(String.format("%.5f", zeroNum/size));
    }
    
    
    public static int getCountOfWord(String word) {
    	return (int)Arrays.stream(word.trim().split(" "))
    			.filter(w -> !w.isEmpty())
    			.count();
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//            .map(Integer::parseInt)
//            .collect(toList());
//
//        Result.plusMinus(arr);
//
//        bufferedReader.close();
    	
    	String s = "    This is Not  a Sentence ";
    	System.out.println(Result.getCountOfWord(s));
    }
}

