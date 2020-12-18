package java8features;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class ForEachExample {

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<30;i++) {
			list.add(new Random().nextInt());
		}
		
		list.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
		});
		List<? extends Number> foo3 = new ArrayList<Number>();  // Number "extends" Number (in this context)
		List<? super Integer> foo2 = new ArrayList<Number>(); // Integer extends Number
		List<? extends Number> foo1 = new ArrayList<Double>();  // Double extends Number
		
		foo2.add(2);
		
		System.out.println(foo2.toString());
		
	}
}
