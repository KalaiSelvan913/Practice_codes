package excercise;

import java.util.Arrays;

public class LongCommonPrefix {

	public static void main(String[] args) {
		String[] strs = {"flower","flow","flight"};
		System.out.println(LongestCommonPrefix(strs));
		System.out.println(LongestCommonPrefixStream(strs));
	}

	private static String LongestCommonPrefix(String[] str) {
		if (str == null || str.length == 0)
			return "";

		String prefix = str[0];   //flower
		for (int i = 1; i < str.length; i++) {
			int j = 0;
			// 0 < 6 && 0 < 4 && f == f ==>  j=1
			// 1< 6 && 1<4 && l == l ==> j=2
			// 2<6 && 2<4 && o == o ==> j=3
			while (j < prefix.length() && j < str[i].length() && prefix.charAt(j) == str[i].charAt(j)) {
				j++;
			}

			prefix = prefix.substring(0, j);

			if (prefix.isEmpty())
				break;
		}

		return prefix;

	}
	
	private static String LongestCommonPrefixStream(String[] str) {
		if(str == null || str.length == 0)
			return "";	
		return Arrays.stream(str).reduce((prefix, current) -> {
			int j = 0;
			while(j< prefix.length() && j<current.length() && prefix.charAt(j) == current.charAt(j)) {
				j++;
			}
			return prefix.substring(0,j);
		}).orElse("");
		}
}
