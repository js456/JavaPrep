package loadBalancer.consistentHashing;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashRouter<T extends Node> {

	private final SortedMap<Long, VirtualNode<T>> ring = new TreeMap();
	private final HashFunction hashFunction;

	public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount) {
		this(pNodes, vNodeCount, new MD5Hash());
	}

	public ConsistentHashRouter(Collection<T> pNodes, int vNodeCount, MD5Hash hashFunction) {
		if (hashFunction == null) {
			throw new NullPointerException("Hash function is null");
		}
		this.hashFunction = hashFunction;
		if (pNodes != null) {
			for (T pNode : pNodes) {
				addNode(pNode, vNodeCount);
			}
		}
	}

	/**
	 * add physic node to the hash ring with some virtual node
	 * 
	 * @param pNode      physical node needs to be added to the hash ring
	 * @param vNodeCount the number of virtual node of the physical node. Value
	 *                   should be greater then equal to 0
	 */
	public void addNode(T pNode, int vNodeCount) {
		if (vNodeCount < 0)
			throw new IllegalArgumentException("illigal virtual node cound :" + vNodeCount);
		int existingReplica = getExistingReplica(pNode);

		for (int i = 0; i < vNodeCount; i++) {
			VirtualNode<T> vNode = new VirtualNode(pNode, 1 + existingReplica);
			ring.put(hashFunction.hash(vNode.getKey()), vNode);
		}

	}

	/**
	 * remove physical node from the ring
	 * 
	 * @param pNode
	 */
	public void removeNode(T pNode) {

		Iterator<Long> itr = ring.keySet().iterator();
		while (itr.hasNext()) {
			Long key = itr.next();
			VirtualNode<T> vNode = ring.get(key);
			if (vNode.isVirtualNodeOf(pNode)) {
				itr.remove();
			}
		}

	}

	/**
	 * with a specified key, route the nearest node instance in the current hash
	 * ring
	 * 
	 * @param objectKey the object to find a nearest node;
	 */
	public T routeNode(String objectKey) {

		if (ring.isEmpty())
			return null;
		Long hashValue = hashFunction.hash(objectKey);
		SortedMap<Long, VirtualNode<T>> tailMap = ring.tailMap(hashValue);
		Long nodeHashValue = !tailMap.isEmpty() ? tailMap.firstKey() : ring.firstKey();
		return ring.get(nodeHashValue).getPhysicalNode();

	}

	private int getExistingReplica(T pNode) {
		int replica = 0;
		for (VirtualNode<T> vNode : ring.values()) {
			if (vNode.isVirtualNodeOf(pNode)) {
				replica++;
			}
		}
		return replica;
	}

	private static class MD5Hash implements HashFunction {

		MessageDigest instance;

		public MD5Hash() {
			try {
				instance = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				System.out.println("No such algorithm exception......");
				e.printStackTrace();
			}
		}

		@Override
		public long hash(String key) {
			instance.reset();
			instance.update(key.getBytes());

			byte[] digest = instance.digest();
			long h = 0;
			for (int i = 0; i < 4; i++) {
				h <<= 8;
				h |= ((int) digest[i]) & 0xFF;
			}
			return h;
		}
	}
}
