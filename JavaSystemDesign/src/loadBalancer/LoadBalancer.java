package loadBalancer;

public interface LoadBalancer {

	String getServer(String clientIP);
}
