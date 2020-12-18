package family.model;

import java.util.ArrayList;
import java.util.List;

import family.service.FamilyHolder;

public class FamilyNode {

	private FamilyNode parent;
	private Gender gender;
	private List<FamilyNode> childs;
	private FamilyNode spouse;
	private String name;

	public FamilyNode(FamilyNode parent, Gender gender, String name) {
		super();
		this.parent = parent;
		this.gender = gender;
		this.childs = new ArrayList<FamilyNode>();
		this.name = name;
	}

	public void addChild(String name, Gender gender) {
		FamilyNode childNode = new FamilyNode(this, gender, name);
		childs.add(childNode);
		if(!this.spouse.getChilds().contains(childNode)) {
			this.spouse.getChilds().add(childNode);
		}
		FamilyHolder.map.put(name, childNode);
		
	}

	public FamilyNode getParent() {
		return parent;
	}

	public void setParent(FamilyNode parent) {
		this.parent = parent;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public List<FamilyNode> getChilds() {
		if(childs == null || childs.size()<=0)
			return this.spouse.getChilds();
		return childs;
	}

	public void setChilds(List<FamilyNode> childs) {
		this.childs = childs;
	}

	public FamilyNode getSpouse() {
		return spouse;
	}

	public void setSpouse(FamilyNode spouse) {
		this.spouse = spouse;
		if(spouse.getSpouse() == null)
			spouse.setSpouse(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean isEqual = false;
		if(obj != null && obj instanceof FamilyNode) {
			isEqual = this.name.equalsIgnoreCase(((FamilyNode)obj).getName());
		}
		return isEqual;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return	this.name.hashCode();
	}

}
