package excercise;

import java.util.regex.Pattern;
import java.util.Collections;
import java.util.regex.Matcher;

public class PatternDecode {

	public static void main(String[] args) {
		System.out.println(decodeString("a10b5"));
		System.out.println(decodeString("c3D6"));
	}
	
	private static String decodeString(String str) {
		StringBuilder result = new StringBuilder();
		Pattern pattern = Pattern.compile("([a-zA-Z])(\\d+)");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			char sampleChar = matcher.group(0).charAt(0);
			int sampleNum = Integer.parseInt(matcher.group(1));
			result.append(String.join("", Collections.nCopies(sampleNum, String.valueOf(sampleChar))));
		}
		return result.toString();
	}

}
