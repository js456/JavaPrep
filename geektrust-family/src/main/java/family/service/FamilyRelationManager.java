package family.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import family.controller.AbstractRelationshipManager;
import family.model.FamilyManagerResponse;
import family.model.FamilyManagerResult;
import family.model.FamilyNode;
import family.model.Gender;
import family.util.FamilyServiceUtil;

public class FamilyRelationManager extends AbstractRelationshipManager {

	@Override
	public FamilyManagerResponse fetchPaternalUncle(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		if (FamilyHolder.map.get(name) != null) {
			FamilyNode familyNode = FamilyHolder.map.get(name);
			if (familyNode.getParent() == null)
				response.setResult(FamilyManagerResult.NONE);
			FamilyNode father = familyNode.getParent().getGender().equals(Gender.MALE) ? familyNode.getParent()
					: familyNode.getParent().getSpouse();
			if (father != null) {
				List<FamilyNode> sibilings = FamilyServiceUtil.fetchSibilings(father.getName());
				if (sibilings == null || sibilings.size() <= 0) {
					response.setResult(FamilyManagerResult.NONE);
				} else {
					List<FamilyNode> paternalUncles = sibilings.stream()
							.filter(node -> (node.getGender() == Gender.MALE)).collect(Collectors.toList());
					List<String> names = paternalUncles.stream().map(FamilyNode::getName).collect(Collectors.toList());
					response.setRelatives(names);
				}
			}

		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}
		return response;
	}

	@Override
	public FamilyManagerResponse fetchMaternalUncle(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		if (FamilyHolder.map.get(name) != null) {
			FamilyNode familyNode = FamilyHolder.map.get(name);
			if (familyNode.getParent() == null)
				response.setResult(FamilyManagerResult.NONE);
			FamilyNode father = familyNode.getParent().getGender().equals(Gender.FEMALE) ? familyNode.getParent()
					: familyNode.getParent().getSpouse();
			if (father != null) {
				List<FamilyNode> sibilings = FamilyServiceUtil.fetchSibilings(father.getName());
				if (sibilings == null || sibilings.size() <= 0) {
					response.setResult(FamilyManagerResult.NONE);
				} else {
					List<FamilyNode> maternalUncles = sibilings.stream()
							.filter(node -> (node.getGender() == Gender.MALE)).collect(Collectors.toList());
					List<String> names = maternalUncles.stream().map(FamilyNode::getName).collect(Collectors.toList());
					response.setRelatives(names);
				}
			}

		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}
		return response;
	}

	@Override
	public FamilyManagerResponse fetchPaternalAunt(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		if (FamilyHolder.map.get(name) != null) {
			FamilyNode familyNode = FamilyHolder.map.get(name);
			if (familyNode.getParent() == null)
				response.setResult(FamilyManagerResult.NONE);
			FamilyNode father = familyNode.getParent().getGender().equals(Gender.MALE) ? familyNode.getParent()
					: familyNode.getParent().getSpouse();
			if (father != null) {
				List<FamilyNode> siblings = FamilyServiceUtil.fetchSibilings(father.getName());
				if (null != siblings && siblings.size() > 0) {
					List<FamilyNode> paternalAunts = siblings.stream()
							.filter(node -> (node.getGender() == Gender.FEMALE)).collect(Collectors.toList());
					List<String> names = paternalAunts.stream().map(FamilyNode::getName).collect(Collectors.toList());
					response.setRelatives(names);

				} else {
					response.setResult(FamilyManagerResult.NONE);
				}
			}

		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}
		return response;
	}

	@Override
	public FamilyManagerResponse fetchMternalAunt(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		if (FamilyHolder.map.get(name) != null) {
			FamilyNode familyNode = FamilyHolder.map.get(name);
			if (familyNode.getParent() == null)
				response.setResult(FamilyManagerResult.NONE);
			FamilyNode father = familyNode.getParent().getGender().equals(Gender.FEMALE) ? familyNode.getParent()
					: familyNode.getParent().getSpouse();
			if (father != null) {
				List<FamilyNode> siblings = FamilyServiceUtil.fetchSibilings(father.getName());
				if (null != siblings && siblings.size() > 0) {
					List<FamilyNode> maternalAunt = siblings.stream()
							.filter(node -> (node.getGender() == Gender.FEMALE)).collect(Collectors.toList());
					List<String> names = maternalAunt.stream().map(FamilyNode::getName).collect(Collectors.toList());
					response.setRelatives(names);
				} else {
					response.setResult(FamilyManagerResult.NONE);
				}
			}

		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}
		return response;
	}

	@Override
	public FamilyManagerResponse fetchSisterInLaw(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		FamilyNode root = FamilyHolder.map.get(name);
		if (root != null) {
			// Find Spouse Sisters
			List<FamilyNode> spouseSisters = null;
			if(root.getSpouse()!= null) {
				spouseSisters = FamilyServiceUtil.fetchSibilings(root.getSpouse().getName()).stream()
				.filter(node -> node.getGender() == Gender.FEMALE).collect(Collectors.toList());
			}else {
				spouseSisters = new ArrayList<FamilyNode>();
			}
			// Wives of siblings
			List<FamilyNode> brothers = FamilyServiceUtil.fetchSibilings(name).stream()
					.filter(node -> node.getGender() == Gender.MALE).collect(Collectors.toList());
			for (FamilyNode node : brothers) {
				spouseSisters.add(node.getSpouse());
			}
			if (spouseSisters.size() > 0) {
				List<String> names = spouseSisters.stream().map(FamilyNode::getName).collect(Collectors.toList());
				response.setRelatives(names);
			} else {
				response.setResult(FamilyManagerResult.NONE);
			}

		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}

		return response;
	}

	@Override
	public FamilyManagerResponse fetchbrotherInLaw(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		FamilyNode root = FamilyHolder.map.get(name);
		if (root != null) {
			// Find Spouse Brothers
			List<FamilyNode> spouseBrothers = null;
			if (root.getSpouse() != null) {
				spouseBrothers = FamilyServiceUtil.fetchSibilings(root.getSpouse().getName()).stream()
						.filter(node -> node.getGender() == Gender.MALE).collect(Collectors.toList());
			} else {
				spouseBrothers = new ArrayList<FamilyNode>();
			}

			// Husbands of siblings
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
			List<FamilyNode> sisters = FamilyServiceUtil.fetchSibilings(name).stream()
					.filter(node -> node.getGender() == Gender.FEMALE).collect(Collectors.toList());
			for (FamilyNode node : sisters) {
				spouseBrothers.add(node.getSpouse());
			}
			if (spouseBrothers.size() > 0) {
				List<String> names = spouseBrothers.stream().map(FamilyNode::getName).collect(Collectors.toList());
				response.setRelatives(names);
			} else {
				response.setResult(FamilyManagerResult.NONE);
			}
		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}

		return response;
	}

	@Override
	public FamilyManagerResponse fetchSon(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		FamilyNode root = FamilyHolder.map.get(name);
		if (root != null) {
			if (root.getChilds() != null) {
				List<FamilyNode> sons = root.getChilds().stream().filter(node -> node.getGender() == Gender.MALE)
						.collect(Collectors.toList());
				List<String> names = sons.stream().map(FamilyNode::getName).collect(Collectors.toList());
				response.setRelatives(names);
			} else {
				response.setResult(FamilyManagerResult.NONE);
			}
		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}
		return response;
	}

	@Override
	public FamilyManagerResponse fetchDaughter(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		FamilyNode root = FamilyHolder.map.get(name);
		if (root != null) {
			if (root.getChilds() != null) {
				List<FamilyNode> daughters = root.getChilds().stream().filter(node -> node.getGender() == Gender.FEMALE)
						.collect(Collectors.toList());
				List<String> names = daughters.stream().map(FamilyNode::getName).collect(Collectors.toList());
				response.setRelatives(names);
			} else {
				response.setResult(FamilyManagerResult.NONE);
			}

		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}
		return response;
	}

	@Override
	public FamilyManagerResponse fetchSibilings(String name) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		if (FamilyHolder.map.get(name) != null) {
			List<FamilyNode> siblings = FamilyServiceUtil.fetchSibilings(name);
			if (siblings.size() > 0) {
				List<String> names = siblings.stream().map(FamilyNode::getName).collect(Collectors.toList());
				response.setRelatives(names);
			} else {
				response.setResult(FamilyManagerResult.NONE);
			}
		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}
		return response;
	}

	@Override
	public FamilyManagerResponse addChild(String mother, String child, Gender gender) {
		FamilyManagerResponse response = new FamilyManagerResponse();
		FamilyNode root = FamilyHolder.map.get(mother);
		if (root != null) {
			if(root.getGender() == Gender.FEMALE) {
				root.addChild(child, gender);
				response.setResult(FamilyManagerResult.CHILD_ADDITION_SUCCEEDED);
			}else {
				response.setResult(FamilyManagerResult.CHILD_ADDITION_FAILED);
			}
		} else {
			response.setResult(FamilyManagerResult.PERSON_NOT_FOUND);
		}
		return response;
	}

}
