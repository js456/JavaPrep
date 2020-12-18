package oops;

public class Inheritence {
	public static void main(String[] args) {
		Animal animal = new Cat();
		animal.walk();
		animal.runFast();
	}
}

class Animal {
	protected Number walk() {
		run();
		System.out.println("Animal walking");
		return null;
	}

	public void run() {
		System.out.println("Animal running");
	}
	
	public void runFast() {
		System.out.println("Running fast");
	}
}

class Cat extends Animal {
	
	public Cat() {
		
	}
	
	protected Integer walk() {
		super.walk();
		System.out.println("Cat walking");
		return null;
	}

	public void run() {
		System.out.println("Cat running");
	}
}