package onlinetest;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
*/
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
	public static void main(String args[]) throws Exception {
		
		String str = "Ani";
		String str1 = "Ani";
		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); // Reading input
		 * from STDIN System.out.println("Hi, " + name + "."); // Writing output to
		 * STDOUT
		 * 
		 * //Scanner Scanner s = new Scanner(System.in); int n = s.nextInt(); // Reading
		 * input from STDIN
		 * 
		 * MyMap<String, Integer>map = new MyMap<String,Integer>(n); for(int i =0; i<n;
		 * i++){ String str = s.nextLine(); System.out.println(str); }
		 * 
		 * 
		 */}

	class Entry<K, V> {
		final K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	class MyMap<K, V> {
		private Entry<K, V>[] buckets;
		private static final int INTIAL_CAPACITY = 16;
		private int size = 0;

		public MyMap() {
			this(INTIAL_CAPACITY);
		}

		public MyMap(int capacity) {
			buckets = new Entry[capacity];
		}

		public void put(K key, V value) {
			Entry<K, V> entry = new Entry<>(key, value, null);
			int bucket = getHash(key) % getBucketSize();
			Entry<K, V> existing = buckets[bucket];
			if (existing == null) {
				buckets[bucket] = entry;
				size++;
			} else {
				while (existing.next != null) {
					if (existing.key.equals(key)) {
						existing.value = value;
						return;
					}
					existing = existing.next;
				}
				if (existing.key.equals(key)) {
					existing.value = value;
				} else {
					existing.next = entry;
					size++;
				}
			}
		}

		public int getHash(K key) {
			return 53 * key.hashCode();
		}

		public int getBucketSize() {
			return this.INTIAL_CAPACITY - size;
		}
	}
}
