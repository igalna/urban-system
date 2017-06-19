package main.java.javaspecific;

public interface DoublyLinkedList {

	public void addNodeToStartOfList(Integer integer);
	public void addNodeToEndOfList(Integer integer);
	public void removeNodeFromList(Integer indexOfIntegerToBeRemoved);
	public Node getStartNode();
	public Node getEndNode();
}