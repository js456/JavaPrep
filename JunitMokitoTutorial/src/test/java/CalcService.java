
public class CalcService {
	
	private AddService addService;
	
	

	public CalcService(AddService addService) {
		super();
		this.addService = addService;
	}

	public AddService getAddService() {
		return addService;
	}

	public void setAddService(AddService addService) {
		this.addService = addService;
	}
	
	public int calc(int num1, int num2) {
		System.out.println("**--- CalcService calc executed ---**");
		return addService.add(num1, num2);
	}
	

	
	
	

}
