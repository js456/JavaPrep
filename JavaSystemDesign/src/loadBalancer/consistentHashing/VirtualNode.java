package loadBalancer.consistentHashing;

public class VirtualNode <T extends Node> implements Node{
	
	final T physicalNode;
	final int replicaIndex;

	
	public VirtualNode(T physicalNode, int replicaIndex) {
		this.physicalNode = physicalNode;
		this.replicaIndex = replicaIndex;
	}


	public T getPhysicalNode() {
		return physicalNode;
	}


	public int getReplicaIndex() {
		return replicaIndex;
	}


	@Override
	public String getKey() {
		return physicalNode.getKey()+"-"+replicaIndex;
	}


	public boolean isVirtualNodeOf(T pNode) {
		return physicalNode.getKey().equals(pNode.getKey());
	}

}
