package designpatterns.behavioural;

/**
 * @author js674007
 * 
 *
 */
public class CommandLineDesignPattern {

	public static void main(String[] args) {
		
		Receiver receiver = new Radio("Radio");
		
		Command command = new TurnOnCommand(receiver);
		Invoker invoker = new Invoker(command);
		invoker.execute();
		invoker.undo();
	}
}


interface Command{
	void execute();
	void undo();
}

class Invoker{
	Command command;
	
	public Invoker(Command command) {
		this.command = command;
	}
	public void setCommend(Command command) {	
		this.command = command;
	}
	public void execute() {
		command.execute();
	}
	
	public void undo() {
		command.undo();
	}
}

class TurnOnCommand implements Command{
	
	Receiver receiver;
	public TurnOnCommand(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void execute() {
		receiver.on();
		
	}

	@Override
	public void undo() {
		receiver.off();
		
	}
	
}

abstract class Receiver{
	private String name;
	public Receiver(String name) {
		this.name = name;
	}
    abstract void on();
    abstract void off();
	
}
class Radio extends Receiver{

	public Radio(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	void on() {
		System.out.println("Radion is on...");
		
	}

	@Override
	void off() {
		System.out.println("Radion is off...");
		
	}
	
}
class TV extends Receiver{

	public TV(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	void on() {
		System.out.println("TV is on...");
		
	}

	@Override
	void off() {
		System.out.println("TC is off...");
		
	}
	
}