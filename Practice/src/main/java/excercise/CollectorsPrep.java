package excercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsPrep {
	public static void main(String[] args) {
		
		System.out.println("toList() using Collectors -> "+
		prepareTemperature().stream().filter(f-> f.getTemperature() > 10)
				.map(City::getName).collect(Collectors.toList()));
		
		System.out.println("toSet() Using Collectors -> "+
				prepareTemperature().stream().filter(f -> f.getTemperature() > 10)
				.map(City::getName).collect(Collectors.toSet()));
		
		System.out.println("toMap() Using Collectors -> "+
				prepareTemperature()
				.stream()
				.filter(f -> f.getTemperature() > 10)
				.collect(Collectors.toMap(
						City::getName, City::getTemperature, (key, identicalKey)-> key
						)));
		System.out.println("collectingAndThen() Using Collectors -> "+prepareTemperature()
				.stream()
				.collect(Collectors.groupingBy(
						City::getName, 
						Collectors.collectingAndThen(Collectors.counting(), f->f.intValue())
						)));
		
		System.out.println("counting() Using Collectors -> "+
				prepareTemperature()
				.stream()
				.collect(Collectors.groupingBy(City::getName, Collectors.counting())));
		
		System.out.println("groupingBy() Using Collectors -> "+
				prepareTemperature().stream().collect(Collectors.groupingBy(City::getName)));
		
		System.out.println("joining() Using Collectors -> "+
				prepareTemperature().stream().filter(f -> f.getTemperature() > 10).map(City::getName).collect(Collectors.joining(", ")));
		
		System.out.println("mapping Using Collectors -> "+
				prepareTemperature().stream().collect(Collectors.groupingBy(City::getName, Collectors.mapping(City::getTemperature, Collectors.toList()))));
		System.out.println("partitioningBy() Using Collectors -> "+
				prepareTemperature().stream().collect(Collectors.partitioningBy(f-> f.getTemperature() > 15)));
		

		Map<String, Integer> map = new HashMap<>();
		map.put("anil", 1000);
		map.put("ankit", 1200);
		map.put("bhavana", 1200);
		map.put("james", 1200);
		map.put("micael", 1000);
		map.put("tom", 1300);
		map.put("daniel", 1300);
		
		System.out.println("Nth Highest - > "+getNthHighestNumber(2, map));
		
		
		
	}
	
	private static List<City> prepareTemperature() {
		List<City> cities = new LinkedList<>();
		cities.add(new City("New Delhi", 33.5)); 
	    cities.add(new City("Mexico", 14)); 
	    cities.add(new City("New York", 13)); 
	    cities.add(new City("Dubai", 43)); 
	    cities.add(new City("London", 15)); 
	    cities.add(new City("Alaska", 1)); 
	    cities.add(new City("Kolkata", 30)); 
	    cities.add(new City("Sydney", 11)); 
	    cities.add(new City("Mexico", 14)); 
	    cities.add(new City("Dubai", 43)); 
	    return new ArrayList<>(cities);
	}
	
	private static Map.Entry<Integer, List<String>> getNthHighestNumber(int num, Map<String, Integer> map){
		return map.entrySet().stream()
			.collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
			.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
			.collect(Collectors.toList()).get(num -1);
	}
	
	
}

class City{
	private String name;
	private double temperature;
	
	public City(String name, double temperature) {
		this.name = name;
		this.temperature = temperature;
	}
	
	public String getName() {
		return name;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	@Override
	public String toString() {
		return name+" --> "+temperature;
	}
}


