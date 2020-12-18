package designpatterns.behavioural;

public class AsyncronousCallbackService {
	

public static void main(String[] args) {
	CallbackEventListenr1 listener = new CallbackEventListenImpl1();
	
	CallbackHandller1 handler = new CallbackHandller1();
	handler.registerCallbackHandller(listener);
	
	listener.callbackEvent();
}
	
	
}

interface CallbackEventListenr1{
	
	void callbackEvent();
}

class CallbackHandller1{
	
	private CallbackEventListenr1 callbackListener;
	
	public void registerCallbackHandller(CallbackEventListenr1 callbackListener) {
		this.callbackListener = callbackListener;
	}
	
	public void doStuff() {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				

				
				System.out.println("Performing operation before syncronous task........");
				
				callbackListener.callbackEvent();
			
				
			}
		}).start();
	}
}
class CallbackEventListenImpl1 implements CallbackEventListenr1{

	@Override
	public void callbackEvent() {
		
		
		System.out.println("Processing callback task.........");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}