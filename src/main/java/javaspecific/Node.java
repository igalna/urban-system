package main.java.javaspecific;

public interface Node {

	public Integer getIntegerContainedInNode();
	public void setNextNode(Node node);
	public void setPreviousNode(Node node);
	public Node getNextNode();
	public Node getPreviousNode();
}