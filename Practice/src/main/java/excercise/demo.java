package excercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class demo {
	public static void main(String[] args) {
		int num = 1634;
		if (amCheck(num) && isAmCheck(num))
			System.out.println("true");
		else
			System.out.println("false");

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<String> strList = Arrays.asList("geeks", "for", "geek", "computer", "science", "All");
		List<String> nameList = Arrays.asList("Kalai", "Paul", "Chenna", "Vijay", "Cheenu", "praveen", "karthi",
				"bharat");

		List<Integer> optionalNumber = Collections.<Integer>emptyList();
		// Arrays.asList(1,2,3,4,5,6);
		/* Filtering and Mapping: */
		List<Integer> filterAndMapping = numbers.stream().filter(n -> n % 2 == 0).map(n -> n * n)
				.collect(Collectors.toList());
		System.out.println("Filter And Mapping -> " + filterAndMapping);

		/* Sorting and Limiting: */
		List<String> sorted = strList.stream().sorted().limit(3).collect(Collectors.toList());
		System.out.println(sorted);

		/* Grouping and Counting: */
		Map<Character, Long> GroupingAndCounting = nameList.stream()
				.collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));
		System.out.println(GroupingAndCounting);

		/* FlatMap and Distinct */
		List<List<Integer>> listOfList = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(3, 4, 5),
				Arrays.asList(5, 6, 7), Arrays.asList(7, 8, 9));

		List<Integer> flatMapAndDistinct = listOfList.stream().flatMap(List::stream).distinct()
				.collect(Collectors.toList());
		System.out.println(flatMapAndDistinct);

		/* Reduce and Optional: */
		Optional<Integer> reduce = optionalNumber.stream().reduce((x, y) -> x * y);
		int optional = reduce.orElse(1);

		System.out.println(optional);

		/* Find and Match: */
		boolean anyMatch = nameList.stream().anyMatch(str -> str.contains("a"));
		System.out.println(anyMatch);

		/* Combining Streams: */
		List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> list2 = Arrays.asList(3, 4, 5, 6, 7);

		List<Integer> combiningStream = list1.stream().filter(list2::contains).collect(Collectors.toList());
		System.out.println(combiningStream);

		/* Implements Sort based on last character in string array */
		String[] array = { "kalai", "selvan", "vijay", "john", "bala" };
		List<String> streamSort = Stream.of(array).sorted(
				(str1, str2) -> Character.compare(str1.charAt(str1.length() - 1), str2.charAt(str2.length() - 1)))
				.collect(Collectors.toList());
		System.out.println(streamSort);
		
		
		/* set validation for parentheses */
		String parantheses = "{[()]}";
		if(isParanthesesBalanced(parantheses)) 
			System.out.println("is balanced");
		else
			System.out.println("is not balanced");
		
		
		
		Integer arr[]= {0, 1, 1, 1, 3, 5, 3, 6, 0, 7, 7, 6, 7};

				Arrays.sort(arr);

				List<Integer> list= Arrays.asList(arr);

				List<Integer> list_1= new ArrayList<>();

				List<Integer> list_2= new ArrayList<>();

				for(int i= 0; i< list.size(); i++) {

					int num1= list.get(i);

					if(!list_1.contains(num1)) {

						list_1.add(num1);

					}else {

						list_2.add(num1);

					}

				}
		 
				list_1.addAll(list_2);

				System.out.println(list_1);
				
				
		/* find Missing Number */
		int[] missingNumberArr = {20,22,24,23,25};
		findMissingNumber(missingNumberArr);
		
				

	}

	private static boolean amCheck(int num) {
		int digit = String.valueOf(num).length();
		return String.valueOf(num).chars().map(Character::getNumericValue).map(d -> (int) Math.pow(d, digit))
				.sum() == num;
	}

	private static boolean isAmCheck(int num) {
		int count = String.valueOf(num).length();
		return IntStream.iterate(num, n -> n / 10).limit(count).map(d -> (int) Math.pow(d % 10, count)).sum() == num;
	}
	
	private static boolean isParanthesesBalanced(String str) {
		Stack<Character> stack = new Stack<>();
		AtomicBoolean valid = new AtomicBoolean(true);
		 str.chars()
         .forEach(c -> {
             if(c == '(') stack.push(')');
             else if(c == '{') stack.push('}');
             else if(c == '[') stack.push(']');
             else if(stack.isEmpty() || stack.pop() != c) valid.set(false); 
         });
		return valid.get() && stack.isEmpty();
	}
	
	
	private static void findMissingNumber(int[] arr) {
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length-1; i++) {
            for (int j = arr[i] + 1; j < arr[i + 1]; j++) {
                System.out.println("" + j);
            }
        }

	}
	
	private static LinkedList mergetTwoList(LinkedList list1, LinkedList list2) {
		
		return null;
	}
	
}

class ParallelStreamExample {
	public static void main(String[] args) {
		// Create a large dataset of numbers
		List<Integer> largeDataset = IntStream.range(0, 1000000).boxed().collect(Collectors.toList());

		// Sequential Stream: Filtering numbers greater than 500000
		long sequentialStartTime = System.currentTimeMillis();

		long sequentialResult = largeDataset.stream().filter(num -> num > 500000).count();

		long sequentialEndTime = System.currentTimeMillis();

		System.out.println("Sequential Result: " + sequentialResult);
		System.out.println("Sequential Time: " + (sequentialEndTime - sequentialStartTime) + " milliseconds");

		// Parallel Stream: Filtering numbers greater than 500000
		long parallelStartTime = System.currentTimeMillis();

		long parallelResult = largeDataset.parallelStream().filter(num -> num > 500000).count();

		long parallelEndTime = System.currentTimeMillis();

		System.out.println("Parallel Result: " + parallelResult);
		System.out.println("Parallel Time: " + (parallelEndTime - parallelStartTime) + " milliseconds");
	}
}
