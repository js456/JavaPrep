package designpatterns.structural;

/**
 * @author js674007
 *
 *	Proxy design pattern is that let's you provide a substitute or a place holder
 * 	for another object to control access to it.
 */
public class ProxyDesignPattern {

}


interface ServiceInterface{
	
	void performOperation();
}

class ActualService implements ServiceInterface{

	@Override
	public void performOperation() {
		System.out.println("Invoking Actual operation......");
		
	}
	
}
class ProxyService implements ServiceInterface{
	
	private ActualService actualService;
	
	public ProxyService() {
		this.actualService = new ActualService();
	}
	
	
	@Override
	public void performOperation() {
		System.out.println("Do precheck ... before doing operation........");
		
		System.out.println(" All prechec done continue do the operation............");
		
		this.actualService.performOperation();
		
	}
	
	public void checkAccess() {
		System.out.println("Check access.......");
	}
	
}