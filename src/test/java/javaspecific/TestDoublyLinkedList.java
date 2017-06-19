package test.java.javaspecific;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
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
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		node = null;
		list = null;
		
		longerList = null;
		startNode = null;
	}
	
	@Before
	public void buildUp() {
		startNode = new NodeImpl(1);
		longerList = new DoublyLinkedListImpl(startNode);
		
		longerList.addNodeToEndOfList(2);
		longerList.addNodeToEndOfList(3);
	}
	@After
	public void tearDown() {
		startNode = null;
		longerList = null;
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
	public void testRemoveNodeFromStartOfList() {
		longerList.removeNodeFromList(0);
		
		int startNodeInt = longerList.getStartNode().getIntegerContainedInNode();
		
		assertEquals(2, startNodeInt);
	}
	
	@Test
	public void testRemoveNodeFromEndOfList() {
		longerList.removeNodeFromList(2);
		
		int endNodeInt = longerList.getEndNode().getIntegerContainedInNode();
		
		assertEquals(2, endNodeInt);
	}
	
	@Test
	public void testRemoveNodeFromMiddleOfList() {
		longerList.removeNodeFromList(1);
		
		int endNodeInt = 3;
		
		assertEquals(3, endNodeInt);
	}
}
