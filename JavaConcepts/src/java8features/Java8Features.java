package java8features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Java8Features {
	
	public static void effectiveFinalTest() {
		
		int test =9;
		for (int i = 0; i < 10; i++) {
		    int counter = 3;
		    new Thread(() -> {
		        System.out.println("i = " + counter); //counter value changes, does not compile!
		    }).start();
		    //counter++;
		}
	}

	public static void forEach() {
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			myList.add(i);

		myList.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);

			}
		});
	}

	public static void runnableFunctional() {
		Runnable r = () -> {
			System.out.println("I am Functional Interface");
		};
		Thread t = new Thread(r);
		t.start();
	}

	public static void streamExample() {
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		List<Integer> temp = myList.stream().filter(obj -> obj % 5 == 0).collect(Collectors.toList());
		temp.forEach(System.out::println);
	}

	public static void main(String[] args) {
		// forEach();
		//TestClass t = new TestClass();
		//t.printRandomInteger();
		//Test.printRandomLong();
		//runnableFunctional();
		//streamExample();
		mapStream();
	}
	public static void mapStream() {
		
		Map<Integer, Integer>treemap = new TreeMap<Integer,Integer>();
		treemap.put(100,5);
		treemap.put(56,5);
		treemap.put(34,5);
		treemap.put(700,5);
		treemap.put(80,5);
		for(int i=100;i>80;i--) {
			int j =i;
			treemap = treemap.entrySet() 
			          .stream() 
			          .filter(map -> map.getKey().intValue() <= j) 
			          .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));  
			System.out.println(treemap.size());
		}
		treemap.forEach((key,value)-> {System.out.println(key);});
		/*
		 * treemap = treemap.entrySet().stream().filter(tempmap ->
		 * tempmap.getKey().intValue() < 90) .collect(Collectors.toMap(tempmap ->
		 * ((Integer)tempmap.getKey()), tempmap -> ((Integer)tempmap.getValue())));
		 */
		/*
		 * Map<Integer, String> map = new HashMap<Integer, String>(); map.put(11,
		 * "Apple"); map.put(22, "Orange"); map.put(33, "Kiwi"); map.put(44, "Banana");
		 * 
		 * map = map.entrySet() .stream() .filter(map -> map.getKey().intValue() <= 22)
		 * .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
		 */
	}
}

interface Test {
	default void printRandomInteger() {
		System.out.println(new Random().nextInt());
	}

	default void printRandomDouble() {
		System.out.println("Random Double...");
	}

	static void printRandomLong() {
		System.out.println(new Random().nextLong());
	}
}

class TestClass implements Test {

}
