package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ComparableVsComparator {

	public static void compareObject() {
		Student s1 = new Student(12, "John");
		Student s2 = new Student(13,"Peter");
		System.out.println(s2.compareTo(s1));
	}
	public static void arrayLisOrdering() {
		Student s1 = new Student(12, "John");
		Student s2 = new Student(13,"Peter");
		Student s3 = new Student(2, "Jack");
		Student s4 = new Student(3,"Smith");
		Student s5 = new Student(1,"Carol");
		ArrayList<Student>list = new ArrayList<Student>();
		list.add(s1);list.add(s2);
		list.add(s3);list.add(s4);list.add(s5);
		
		System.out.println(list.toString());
		
		//Collections.sort(list);
		//System.out.println(list.toString());
		
		list.sort(new Comparator<Student>() {

			public int compare(Student o1, Student o2) {
				if(o1.getRollNsumber() < o2.getRollNsumber())
					return -1;
				if(o1.getRollNsumber() > o2.getRollNsumber())
					return 1;
				else
					return 0;
			}
		});
		
		List<Student>list1 = new ArrayList<Student>(list);
		list1.add(new Student(0,"Akriti"));
		// Using java 8 lamda 
		Comparator<Student>comparator = (Student o1, Student o2)->o1.getRollNsumber()- o2.getRollNsumber();
		Comparator<Student>comparator1 = Comparator.comparing(Student::getRollNsumber);
		Collections.sort(list1, comparator1);
		System.out.println(list1.toString());
		
		Iterator<Student> iterator= list1.iterator();

		while(iterator.hasNext()) {
			iterator.next();
			//System.out.println(iterator.next().getName());
//			//list1.add(null);
		}
		
		//Collections.reverseOrder(comparator1);
		Collections.reverse(list1);
		System.out.println(list1.toString());
	}
	public static void main(String[] args) {
		//compareObject();
		arrayLisOrdering();
	}
}

class Student implements Comparable<Student>, Comparator<Student>{
	private int rollNsumber;
	private String name;
	
	public Student(int rollNumber, String name) {
		this.rollNsumber = rollNumber;
		this.name = name;
	}

	public int getRollNsumber() {
		return rollNsumber;
	}

	public void setRollNsumber(int rollNsumber) {
		this.rollNsumber = rollNsumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Student o) {
		Student studentObj = (Student)o;
		if(this.rollNsumber < studentObj.rollNsumber)
			return -1;
		if(this.rollNsumber > studentObj.rollNsumber)
			return 1;
		else
			return 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("[Roll Number:");
		sb.append(this.rollNsumber);
		sb.append("],");
		sb.append("[Name:");
		sb.append(this.name);
		sb.append("]");
		sb.append("}");
		return sb.toString();
	}

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.rollNsumber < o2.rollNsumber)
			return -1;
		if(o1.rollNsumber > o2.rollNsumber)
			return 1;
		else
			return 0;
	}

	
}