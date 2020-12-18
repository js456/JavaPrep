package designpatterns.behavioural;

public class SyncronousCallbackService {

	public static void main(String[] args) {
		CallbackEventListenr listener = new CallbackEventListenImpl();
		
		CallbackHandller handler = new CallbackHandller();
		handler.registerCallbackHandller(listener);
		handler.doStuff();
	}
}


interface CallbackEventListenr{
	
	void callbackEvent();
}

class CallbackHandller{
	
	private CallbackEventListenr callbackListener;
	
	public void registerCallbackHandller(CallbackEventListenr callbackListener) {
		this.callbackListener = callbackListener;
	}
	
	public void doStuff() {
		
		System.out.println("Performing operation before syncronous task........");
		
		callbackListener.callbackEvent();
	}
}
class CallbackEventListenImpl implements CallbackEventListenr{

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