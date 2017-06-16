package test.java.general;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.java.general.MergeList;

public class TestMergeList {

	@Test
	public void testMergeSortedLists() {
		List<Integer> firstList = new ArrayList<Integer>(Arrays.asList(1, 4, 6));
		List<Integer> secondList = new ArrayList<Integer>(Arrays.asList(2, 3, 5));
		
		List<Integer> mergedList = MergeList.mergeList(firstList, secondList);
		int value = mergedList.get(4).intValue();
		System.out.println(mergedList);
		
		assertEquals(5, value);
	}
}