package family.model;

import java.util.List;

public class FamilyManagerResponse {

	private List<String> relatives;
	private FamilyManagerResult result;

	public List<String> getRelatives() {
		return relatives;
	}

	public void setRelatives(List<String> relatives) {
		this.relatives = relatives;
	}

	public FamilyManagerResult getResult() {
		return result;
	}

	public void setResult(FamilyManagerResult result) {
		this.result = result;
	}

}
