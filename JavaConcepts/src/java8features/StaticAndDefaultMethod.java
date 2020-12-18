package java8features;

/**
 * @author js674007
 * 
 *         We know that Java doesn’t provide multiple inheritance in Classes
 *         because it leads to Diamond Problem. So how it will be handled with
 *         interfaces now, since interfaces are now similar to abstract classes.
 *         The solution is that compiler will throw exception in this scenario
 *         and we will have to provide implementation logic in the class
 *         implementing the interfaces.
 *
 */
public class StaticAndDefaultMethod {

	public static void main(String[] args) {
		A a = new Demo();
		
		a.doSomethind();
	}
	
}

interface A{
	default void doSomethind(){
		System.out.println("Doing something A");
	}
	
	static void makeStaticCall() {
		System.out.println("Static Call A..");
	}
	
	void method();
}

interface B{
	default void doSomethind(){
		System.out.println("Doing something B");
	}
	
	static void makeStaticCall() {
		System.out.println("Static Call B..");
	}
}

interface C	extends A{
	default void doSomethind(){
		System.out.println("Doing something C");
	}
	
	static void makeStaticCall() {
		System.out.println("Static Call C..");
	}
}

class Demo implements C,B{

	@Override
	public void doSomethind() {
		// TODO Auto-generated method stub
		C.super.doSomethind();
	}

	@Override
	public void method() {
		C.makeStaticCall();
		
	}
	
}