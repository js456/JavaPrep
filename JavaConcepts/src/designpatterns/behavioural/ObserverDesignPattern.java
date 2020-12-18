package designpatterns.behavioural;

import java.util.ArrayList;
import java.util.List;

/**
 * @author js674007
 * 	Observer design pattern lets you define one to many dependency between object 
 * 	so that when one object changes state, all its dependents are notified and updated automatically.
 *
 */
public class ObserverDesignPattern {

	public static void main(String[] args) {
		Subject subject = new SubjectImpl();
		
		Observer observer = new Person("John");
		Observer observer1 = new Person("Ronak");
		Observer observer2 = new Person("Peter");
		
		subject.register(observer);
		subject.register(observer1);
		subject.register(observer2);
		
		subject.notifyObserver();
		subject.register(new Person("Tipu"));
		((SubjectImpl)subject).updateNumber();
	}
}


interface Subject{
	void register(Observer observer);
	void unregister(Observer observer);
	void notifyObserver();
}

interface Observer{
	void notifyMe(int i);
	
}

class SubjectImpl implements Subject{

	List<Observer>myOberservers;
	private int glodenNumber =2;
	
	public SubjectImpl() {
		this.myOberservers = new ArrayList<Observer>();
	}
	
	@Override
	public void register(Observer observer) {
		myOberservers.add(observer);
		
	}

	@Override
	public void unregister(Observer observer) {
		myOberservers.remove(observer);
		
	}

	@Override
	public void notifyObserver() {
		myOberservers.stream().forEach(
				(Observer o)-> o.notifyMe(glodenNumber));
	}
	
	public void updateNumber() {
		this.glodenNumber = this.glodenNumber +3;
		notifyObserver();
	}
	
}

class Person implements Observer{

	private String name;
	public Person(String name) {
		this.name = name;
	}
	
	@Override
	public void notifyMe(int i) {
		
		System.out.println(name+" is notified and the golder number is: "+i);
	}
	
}