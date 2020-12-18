package designpatterns.creational;

public class AbstructFactoryDesignPattern {

}
abstract class Computer {
    
    public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();
     
    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}

class PC extends Computer{

	@Override
	public String getRAM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

class Server extends Computer{

	@Override
	public String getRAM() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHDD() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCPU() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

interface ComputerAbstructFactory{
	public Computer createComputer();
}

class PCFactory implements ComputerAbstructFactory{

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new PC();
	}
	
}

class ServerFactory implements ComputerAbstructFactory{

	@Override
	public Computer createComputer() {
		// TODO Auto-generated method stub
		return new Server();
	}
}

class ComputerFactory{
	public static Computer getComputer(ComputerAbstructFactory factory) {
		return factory.createComputer();
	}
}