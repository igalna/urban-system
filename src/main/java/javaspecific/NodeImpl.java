package main.java.javaspecific;

public class NodeImpl implements Node {

	private Integer integerContainedInNode;
	private Node nextNode;
	private Node previousNode;

	public NodeImpl(Integer integer) {
		this.integerContainedInNode = integer;
	}
	
	public Integer getIntegerContainedInNode() {
		return integerContainedInNode.intValue();
	}
	
	public void setNextNode(Node node) {
		this.nextNode = node;
	}
	
	public void setPreviousNode(Node node) {
		this.previousNode = node;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public Node getPreviousNode() {
		return previousNode;
	}
}
