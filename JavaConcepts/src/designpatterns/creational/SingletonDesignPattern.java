package designpatterns.creational;

import java.io.Serializable;

public class SingletonDesignPattern {

}
class EagerInitializedSingleton {
    
    private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
    
    //private constructor to avoid client applications to use constructor
    private EagerInitializedSingleton(){}

    public static EagerInitializedSingleton getInstance(){
        return instance;
    }
}

class StaticBlockSingleton{
	
	private static StaticBlockSingleton obj;
	
	private StaticBlockSingleton() {
		
	}
	static {
		try {
			obj = new StaticBlockSingleton();
		}catch (Exception e) {
			
		}
	}
	
	public static StaticBlockSingleton getInstance() {
		return obj;
	}
}

class LazyInitializedSingleton {

    private static LazyInitializedSingleton instance;
    
    private LazyInitializedSingleton(){}
    
    
    // add synchronized to make it thread safe
    public static LazyInitializedSingleton getInstance(){
        if(instance == null){
            instance = new LazyInitializedSingleton();
        }
        return instance;
    }
}
class LazyInitializedSingletonThreadSafe {

    private static LazyInitializedSingletonThreadSafe instance;
    
    private LazyInitializedSingletonThreadSafe(){}
    
    
    // add synchronized to make it thread safe
    public static LazyInitializedSingletonThreadSafe getInstance(){
        if(instance == null){
        	synchronized (LazyInitializedSingletonThreadSafe.class) {
				if(instance == null) {
					instance = new LazyInitializedSingletonThreadSafe();
				}
			}
        }
        return instance;
    }
}

class SerlizedSingleton implements Serializable{
    private static final long serialVersionUID = -7604766932017737115L;

    private SerlizedSingleton(){}
    
    private static class SingletonHelper{
    	private static final SerlizedSingleton instance = new SerlizedSingleton();
    }
    
    public static SerlizedSingleton getInstance() {
    	return SingletonHelper.instance;
    }
}

