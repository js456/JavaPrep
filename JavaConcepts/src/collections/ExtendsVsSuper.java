package collections;

import java.util.ArrayList;
import java.util.List;

public class ExtendsVsSuper {

	public static void main(String[] args) {

		//consumer(producer());
	}

	public static List<? extends Number> producer() {

		List list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			list.add(i);
		return list;
	}

	public static void consumer(List<? super Integer> list) {

		list.forEach(System.out::print);
	}

	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for (int i = 0; i < src.size(); i++)
			dest.set(i, src.get(i));
	}
}
