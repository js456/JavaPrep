package oops;

public class MethodOverriding {
	
	public static void main(String[] args) {
		
		System.out.println("Calling from main.......");
		Parent parent = new Child();
		
		parent.testProtcted();
		parent.print();
		//parent.testStaticChild();
		
		System.out.println(Parent.parentObject);
		System.out.println(Child.childObject);
	}

}


class Parent{
	
	public static int parentObject =0;
	
	int a;
	
	{
		System.out.println("parentObject count: "+parentObject);
		parentObject++;
	}
	
	static {
		System.out.println("Calling from static block........");
	}
	
	public static void testStatic()	{
		System.out.println("I am from parent static........");
	}
	
	private void testPrivate() {
		System.out.println("I am from private.......");
	}
	
	protected void testProtcted() {
		System.out.println("I am from protected..........");
	}
	
	public void print() {
		System.out.println("parent print");
	}
}

interface OverrideTest{
	
	public Number printInt(Number number);
}

class Child extends Parent implements OverrideTest{
	
	static {
		System.out.println("Calling from child static .......");
	}
	public static int childObject =0;
	
	{
		System.out.println("childObject count :"+childObject);
		childObject++;
	}
	private void testPrivate() {
		System.out.println("I am from private.......a "+a);
	}
	
	public static void testStatic() {
		System.out.println("I am from child static .......");
	}
	
	public static void testStaticChild() {
		System.out.println("I am from child static .......");
	}
	
	public void print() {
		System.out.println("child print");
	}

	@Override
	public Integer printInt(Number number) {
		// TODO Auto-generated method stub
		return null;
	}
	
}



