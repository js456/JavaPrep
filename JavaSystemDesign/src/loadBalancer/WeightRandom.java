package loadBalancer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WeightRandom implements LoadBalancer{

	@Override
	public String getServer(String clientIP) {
		Set<String> ipSet = IpPool.ipMap.keySet();
		
		List<String> serverList = new ArrayList<String>();
		
		Iterator<String>iterator = ipSet.iterator();
		while(iterator.hasNext()) {
			String server = iterator.next();
			Integer weight = IpPool.ipMap.get(server);
			if(weight!= null && weight>0) {
				for(int i=0;i<weight;i++) {
					serverList.add(server);
				}
			}
		}
		Integer index = new Random().nextInt(serverList.size());
		
		return serverList.get(index);
	}

}
