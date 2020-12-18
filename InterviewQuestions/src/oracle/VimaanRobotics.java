package oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class VimaanRobotics {

	/**
	 * 
	 * 
	 * @param subsetA
	 * @param subsetB
	 * @return method will return characters which are not common in bots sets
	 */
	public static Set<Character> isSubsetHasDes(CopyOnWriteArraySet<Character> subsetA,
			CopyOnWriteArraySet<Character> subsetB) {
		subsetA.forEach(ch -> {
			if (subsetB.contains(ch)) {
				subsetB.remove(ch);
				subsetA.remove(ch);
			}
		});
		subsetB.addAll(subsetA);
		return subsetB;
	}

	/**
	 * @param container1
	 * @param container2
	 * 
	 * traverse both subset and check each subset compare with subset in different subset
	 * 
	 * @return 
	 */
	public static Map<Integer, Set<Character>> filterSets(List<CopyOnWriteArraySet<Character>> container1,
			List<CopyOnWriteArraySet<Character>> container2) {

		Map<Integer, Set<Character>> decrpncyMap = new HashMap<Integer, Set<Character>>();
		for (int i = 0; i < container1.size(); i++) {
			Set<Character> descrpncySet = isSubsetHasDes(container1.get(i), container2.get(i));
			if (descrpncySet.size() > 0) {
				decrpncyMap.put(i, descrpncySet);
			}
		}
		return decrpncyMap;
	}

	/**
	 * @param decrpncyMap
	 * 
	 * print map 
	 */
	public static void printDescrpncy(Map<Integer, Set<Character>> decrpncyMap) {
		decrpncyMap.forEach((key, value) -> {
			System.out.println("" + key + ": " + value);
		});
	}

	public static void main(String[] args) {

		CopyOnWriteArraySet<Character> setA1 = new CopyOnWriteArraySet<>(Arrays.asList('a', 'b', 'c'));
		CopyOnWriteArraySet<Character> setB1 = new CopyOnWriteArraySet<>(Arrays.asList('a', 'd', 'c', 'y'));

		CopyOnWriteArraySet<Character> setA2 = new CopyOnWriteArraySet<>(Arrays.asList('i', 'k', 'j'));
		CopyOnWriteArraySet<Character> setB2 = new CopyOnWriteArraySet<>(Arrays.asList('a', 'd'));

		CopyOnWriteArraySet<Character> setA3 = new CopyOnWriteArraySet<>(Arrays.asList('p', 'q', 'r'));
		CopyOnWriteArraySet<Character> setB3 = new CopyOnWriteArraySet<>(Arrays.asList('p', 'q', 'r', 't'));

		List<CopyOnWriteArraySet<Character>> container1 = new ArrayList<CopyOnWriteArraySet<Character>>();
		List<CopyOnWriteArraySet<Character>> container2 = new ArrayList<CopyOnWriteArraySet<Character>>();

		container1.add(setA1);
		container2.add(setB1);

		container1.add(setA2);
		container2.add(setB2);

		container1.add(setA3);
		container2.add(setB3);

		Map<Integer, Set<Character>> decrpncyMap = filterSets(container1, container2);

		printDescrpncy(decrpncyMap);
	}
}
