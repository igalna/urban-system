package test.java.javaspecific;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import main.java.javaspecific.DoublyLinkedList;
import main.java.javaspecific.DoublyLinkedListImpl;
import main.java.javaspecific.Node;
import main.java.javaspecific.NodeImpl;

public class TestDoublyLinkedList {

	private static Node node;
	private static DoublyLinkedList list;
	
	private static DoublyLinkedList longerList;
	private static Node startNode;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		node = new NodeImpl(1);
		list = new DoublyLinkedListImpl(node);
		
		startNode = new NodeImpl(1);
		longerList = new DoublyLinkedListImpl(startNode);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Test
	public void testAddNodeToStartOfList() {
		list.addNodeToStartOfList(5);
		int startNodeInt = list.getStartNode().getIntegerContainedInNode();
		assertEquals(5, startNodeInt);
	}

	@Test
	public void testAddNodeToEndOfList() {
		list.addNodeToEndOfList(101394);
		int endNodeInt = list.getEndNode().getIntegerContainedInNode();
		assertEquals(101394, endNodeInt);
	}
	
	@Test
	public void testRemoveNodeFromList() {
		longerList.addNodeToEndOfList(2);
		longerList.addNodeToEndOfList(3);
		
		longerList.removeNodeFromList(1);
		
		System.out.println(longerList.getStartNode().getIntegerContainedInNode());
		System.out.println(longerList.getEndNode().getIntegerContainedInNode());
	}
}
