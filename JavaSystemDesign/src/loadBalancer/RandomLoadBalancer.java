package loadBalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class RandomLoadBalancer implements LoadBalancer{

	@Override
	public String getServer(String clientIP) {
		Set<String> ipSet = IpPool.ipMap.keySet();
		
		List<String> serverList = new ArrayList<String>();
		serverList.addAll(ipSet);
		String target = serverList.get(new Random().nextInt(serverList.size()));
		return target;
	}

}
