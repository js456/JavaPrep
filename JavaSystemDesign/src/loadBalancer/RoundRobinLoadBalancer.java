package loadBalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoundRobinLoadBalancer implements LoadBalancer{

	public static Integer position = 0;
	@Override
	public String getServer(String clientIP) {
		Set<String> ipSet = IpPool.ipMap.keySet();
		
		List<String> serverList = new ArrayList<String>();
		serverList.addAll(ipSet);
		String target = null;
		
		synchronized (position) {
			if(position> serverList.size()) {
				position =0;
			}
			target = serverList.get(position);
			position++;
			
		}
		return target;
		
	}

}
