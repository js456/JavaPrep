package designpatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 * @author js674007
 *
 * Iterator design pattern lets you access the elements of an aggregate object sequentially without 
 * exposing underlying representation.
 */
public class IteratorDesignPattern {

	public static void main(String[] args) {
		Iterator itr = new ConcreteCollection().createIterator();
		
		while(itr.hasMore()) {
			System.out.println(itr.getNext());
		}
	}
}

interface Iterator{
	String getNext();
	boolean hasMore();
}

interface IterableCollection{
	Iterator createIterator();
}

class ConcreteCollection implements IterableCollection{

	Iterator iterator;
	
	List<String>list = new ArrayList<>();
	
	public ConcreteCollection() {
		list.add("a");
		list.add("b");
		list.add("c");
	}
	
	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new ConcreteIterator(this);
	}
	
	public int getSize() {
		return this.list.size();
	}
	
	public String getStringAtIndex(int i) {
		return this.list.get(i);
	}
	
}

class ConcreteIterator implements Iterator{

	ConcreteCollection collection;
	private int size;
	private int currentIndex = -1;
	
	public ConcreteIterator(ConcreteCollection concreteCollection) {
		this.collection = concreteCollection;
		this.size = collection.getSize();
	}

	@Override
	public String getNext() {
		currentIndex ++;
		return collection.getStringAtIndex(currentIndex);
		
	}

	@Override
	public boolean hasMore() {
		// TODO Auto-generated method stub
		return size-1!=currentIndex;
	}
	
}