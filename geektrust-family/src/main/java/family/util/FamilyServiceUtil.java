package family.util;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import family.model.FamilyNode;
import family.service.FamilyHolder;

public class FamilyServiceUtil {

	public static List<FamilyNode> fetchSibilings(String name) {
		if (FamilyHolder.map.get(name) != null) {
			FamilyNode familyNode = FamilyHolder.map.get(name);
			FamilyNode parent;
			if (familyNode.getParent() != null) {
				parent = familyNode.getParent();
				List<FamilyNode> siblings = parent.getChilds().stream().filter(node -> (!node.getName().equals(name)))
						.collect(Collectors.toList());
				return siblings;
			} else {
				return Collections.emptyList();
			}
		}
		return Collections.emptyList();
	}
}
