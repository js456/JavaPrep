package family.service;

import family.controller.AbstractRelationshipManager;
import family.controller.FamilyMainController;
import family.model.FamilyManagerResponse;
import family.model.FamilyManagerResult;
import family.model.Gender;

public class FamilyControllerImpl implements FamilyMainController {

	private AbstractRelationshipManager relationshipManager;
	
	public FamilyControllerImpl() {
		relationshipManager = new FamilyRelationManager();
	}
	public FamilyManagerResponse addChild(String mother, String child, Gender gender) {
		return relationshipManager.addChild(mother, child, gender);
	}

	public FamilyManagerResponse getRelationship(String name, String relationship) {
		FamilyManagerResponse response = null;
		switch (relationship) {
		case "Paternal-Uncle":
			response = relationshipManager.fetchPaternalUncle(name);
			break;
		case "Maternal-Uncle":
			response = relationshipManager.fetchMaternalUncle(name);
			break;
		case "Paternal-Aunt":
			response = relationshipManager.fetchPaternalAunt(name);
			break;
		case "Maternal-Aunt":
			response = relationshipManager.fetchMternalAunt(name);
			break;
		case "Sister-In-Law":
			response = relationshipManager.fetchSisterInLaw(name);
			break;
		case "Brother-In-Law":
			response = relationshipManager.fetchbrotherInLaw(name);
			break;
		case "Son":
			response = relationshipManager.fetchSon(name);
			break;
		case "Daughter":
			response = relationshipManager.fetchDaughter(name);
			break;
		case "Siblings":
			response = relationshipManager.fetchSibilings(name);
			break;
		default:
			response = new FamilyManagerResponse();
			response.setResult(FamilyManagerResult.NONE);
			break;
		}
		return response;
	}

}
