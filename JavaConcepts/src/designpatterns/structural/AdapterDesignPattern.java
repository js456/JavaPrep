package designpatterns.structural;

/**
 * @author js674007
 *
 *	Adapter design pattern allow incompatible interface to collaborate.
 *
 */
public class AdapterDesignPattern {
public static void main(String[] args) {
	Bird bird = new Duck();
	bird.makeSound();
	
	Bird bird1 = new BirdAdapter(new PlasticBirdImpl());
	
	bird1.makeSound();
}
}

class BirdAdapter implements Bird{

	
	private PlasticBird plasticBird;
	
	public BirdAdapter(PlasticBird plasticBird) {
		this.plasticBird = plasticBird;
	}
	
	@Override
	public void makeSound() {
		this.plasticBird.squeak();		
	}
	
}

interface Bird{
	void makeSound();
}

interface PlasticBird{
	void squeak();
}

class PlasticBirdImpl implements PlasticBird{

	@Override
	public void squeak() {
		System.out.println("Squeak");
		
	}
	
}
class Duck implements Bird{

	@Override
	public void makeSound() {
		// TODO Auto-generated method stub
		
	}
	
}
