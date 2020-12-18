import java.util.HashMap;
import java.util.Map;

public class MyRunnable implements Runnable {

	
	public static final String MAXAUTH_EXCEEDED_BLOCKCARD= "MAXAUTH_EXCEEDED_BLOCKCARD";
	@Override
	public void run() {
		
		System.out.println("Running Thread");
		
	}
	
	/*
	 * public static void main(String[] args) {
	 * 
	 * Thread t = new Thread(new MyRunnable(),"T1"); t.start(); }
	 */

	
	  public static void processPluginConfigData(Map<String, String> config, Map<String, String> additionalParams) {
		     
		     if(additionalParams == null)
		        return;
		     //Map<String, String> config = pluginConfigurationData.getPluginConfigKeyVal();
		     for (Map.Entry<String, String> entry : additionalParams.entrySet()) {
		        if (null != config.get(entry.getKey()))
		           config.put(entry.getKey(), additionalParams.get(entry.getKey()));
		        else
		           config.put(entry.getKey(), entry.getValue());

		     }
		   //Intialize password for PWCallback
		    // FiServConstants.PWCALLBACKKEYPASSWORDVAL= config.get(FiServConstants.PWCALLBACKKEYPASSWORD);
		     //pluginConfigurationData.setPluginConfigKeyVal(config);
		  }
		  
	   public static boolean notEmpty(String str) {
		      return str != null && str.length() > 0 && str.trim().length() > 0;
		   }
		  public static void main(String[] args) {
		     Map<String, String> config = new HashMap<String,String>();
		     config.put("plugin-key", "Plugin-value");
		     config.put("tenent_id", "Plugin-tenent");
		     config.put("MAXAUTH_EXCEEDED_BLOCKCARD", "false");
		     Map<String, String> additionalParam = new HashMap<String,String>();
		     additionalParam.put("additional-key", "Plugin-value");
		     additionalParam.put("tenent_id", "additional-tenent");
		     //data.setPluginConfigKeyVal(config);
		     processPluginConfigData(config, additionalParam);
		     
		     for(Map.Entry<String, String> entry : config.entrySet()) {
		        System.out.println("key: "+entry.getKey()+" value:"+entry.getValue());
		     }
		     
             if (notEmpty(config.get(MAXAUTH_EXCEEDED_BLOCKCARD)) && config.get(MAXAUTH_EXCEEDED_BLOCKCARD).equalsIgnoreCase("false")) {
            	 System.out.println("Locking policy is not configured. So not invoking block card interface");
          }else {
        	  System.out.println("Locking policy is configured. So invoking block card interface");
          }
		     
		  }
}
