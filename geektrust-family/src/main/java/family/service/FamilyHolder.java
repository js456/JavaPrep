package family.service;

import java.util.HashMap;
import java.util.Map;

import family.model.FamilyNode;
import family.model.Gender;

public class FamilyHolder {

	public static Map<String, FamilyNode> map;

	static {
		map = new HashMap<String, FamilyNode>();

		FamilyNode king = new FamilyNode(null, Gender.MALE, "King Shan");
		map.put("King Shan", king);
		FamilyNode queen = new FamilyNode(null, Gender.FEMALE, "Queen Anga");
		map.put("Queen Anga", queen);
		king.setSpouse(queen);
		queen.setSpouse(king);
		king.addChild("Chit", Gender.MALE);
		king.addChild("Ish", Gender.MALE);
		king.addChild("Vich", Gender.MALE);
		king.addChild("Aras", Gender.MALE);
		king.addChild("Satya", Gender.FEMALE);

		FamilyNode Amba = new FamilyNode(null, Gender.FEMALE, "Amba");
		map.get("Chit").setSpouse(Amba);
		Amba.addChild("Dritha", Gender.FEMALE);
		Amba.addChild("Tritha", Gender.FEMALE);
		Amba.addChild("Vritha", Gender.MALE);
		map.put("Amba", Amba);
		FamilyNode Jaya = new FamilyNode(null, Gender.MALE, "Jaya");
		map.put("Jaya", Jaya);
		map.get("Dritha").setSpouse(Jaya);
		Jaya.addChild("Yodhan", Gender.FEMALE);
		
		
		FamilyNode Lika = new FamilyNode(null, Gender.FEMALE, "Lika");
		map.put("Lika", Lika);
		map.get("Vich").setSpouse(Lika);
		Lika.addChild("Vila", Gender.FEMALE);
		Lika.addChild("Chika", Gender.FEMALE);
		FamilyNode Chitra = new FamilyNode(null, Gender.FEMALE, "Chitra");
		map.put("Chitra", Chitra);
		map.get("Aras").setSpouse(Chitra);
		Chitra.addChild("Jnki", Gender.FEMALE);
		Chitra.addChild("Ahit", Gender.MALE);
		FamilyNode Arit = new FamilyNode(null, Gender.MALE, "Arit");
		map.put("Arit", Arit);
		map.get("Jnki").setSpouse(Arit);
		Arit.addChild("Lavnya", Gender.FEMALE);
		Arit.addChild("Lakl", Gender.MALE);
		FamilyNode Vyan = new FamilyNode(null, Gender.MALE, "Vyan");
		map.put("Vyan", Vyan);
		map.get("Satya").setSpouse(Vyan);
		Vyan.addChild("Asva", Gender.MALE);
		Vyan.addChild("Vyas", Gender.MALE);
		Vyan.addChild("Atya", Gender.FEMALE);

		FamilyNode Satvy = new FamilyNode(null, Gender.FEMALE, "Satvy");
		map.put("Satvy", Satvy);
		map.get("Asva").setSpouse(Satvy);
		Satvy.addChild("Vasa", Gender.MALE);

		FamilyNode Krpi = new FamilyNode(null, Gender.FEMALE, "Krpi");
		map.put("Krpi", Krpi);
		map.get("Vyas").setSpouse(Krpi);
		Krpi.addChild("Kriya", Gender.MALE);
		Krpi.addChild("Krithi", Gender.FEMALE);



	}
}
