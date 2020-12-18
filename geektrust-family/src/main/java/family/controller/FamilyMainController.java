package family.controller;

import family.model.FamilyManagerResponse;
import family.model.Gender;

public interface FamilyMainController {

	public FamilyManagerResponse addChild(String mother, String child, Gender gender);
	public FamilyManagerResponse getRelationship(String name, String relationship);
}
