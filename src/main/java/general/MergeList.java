package main.java.general;

import java.util.Collections;
import java.util.List;

public class MergeList {

	public static List<Integer> mergeList(List<Integer> firstList, List<Integer> secondList) {
		firstList.addAll(secondList);
		Collections.sort(firstList);
		return firstList;
	}
}