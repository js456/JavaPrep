package loadBalancer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class IpHash implements LoadBalancer{

	@Override
	public String getServer(String clientIP) {
        Set<String> servers = IpPool.ipMap.keySet();
        List<String> serverList = new ArrayList<>();
        serverList.addAll(servers);
        
        Integer index = clientIP.hashCode()%serverList.size();
		return serverList.get(index);
	}

}
