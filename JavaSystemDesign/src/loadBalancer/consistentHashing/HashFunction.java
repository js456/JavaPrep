package loadBalancer.consistentHashing;

public interface HashFunction {
	long hash(String key);
}
