package excercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCountExample {

	public static void main(String[] args) {
		String path = "C:/Users/fasupport32/Documents/Sample.txt";
		
		try {
			Map<String, Long> wordCountMap = Files.lines(Paths.get(path))
					.flatMap(line -> Arrays.stream(line.split("\\s+")))
					.map(String::toLowerCase)
					.filter(word -> !word.isEmpty())
					.collect(Collectors.groupingBy(word-> word, Collectors.counting()));
			wordCountMap.forEach((word, count) -> System.out.println(word+" : "+count));
			
		}catch (IOException e) {
			e.printStackTrace();
		}

	}

}
