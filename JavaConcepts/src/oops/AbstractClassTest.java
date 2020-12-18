package oops;

public class AbstractClassTest {

	public static void main(String[] args) {
		
		Member member = new Member();
		System.out.println(member.addItemToCart("Car"));
		System.out.println(member.placeOrder("Car"));
		System.out.println();
	}
}


abstract class Customer {
	  private String cart;
	  private String order;

	  public String getShoppingCart() {
		return cart;};
	  public boolean addItemToCart(String item) {
		return false;};
	  public boolean removeItemFromCart(String item) {
		return false;};
	}

class Guest extends Customer {
	  public boolean registerAccount() {return false;};
	}

class Member extends Customer {
	  private String account;
	  public String placeOrder(String order) {
		return order;
	}
	}