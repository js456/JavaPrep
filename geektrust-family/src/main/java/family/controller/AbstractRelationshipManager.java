package family.controller;

import family.model.FamilyManagerResponse;
import family.model.Gender;

public abstract class AbstractRelationshipManager {

	public abstract FamilyManagerResponse fetchPaternalUncle(String name);
	public abstract FamilyManagerResponse fetchMaternalUncle(String name);
	public abstract FamilyManagerResponse fetchPaternalAunt(String name);
	public abstract FamilyManagerResponse fetchMternalAunt(String name);
	public abstract FamilyManagerResponse fetchSisterInLaw(String name);
	public abstract FamilyManagerResponse fetchbrotherInLaw(String name);
	public abstract FamilyManagerResponse fetchSon(String name);
	public abstract FamilyManagerResponse fetchDaughter(String name);
	public abstract FamilyManagerResponse fetchSibilings(String name);
	public abstract FamilyManagerResponse addChild(String mother, String child, Gender gender);
}
