package main.java.javaspecific;

public class DoublyLinkedListImpl implements DoublyLinkedList {

	private Node startNode;
	private Node endNode;
	
	private int lengthOfList;
	
	public DoublyLinkedListImpl(Node node) {
		this.startNode = node;
		this.endNode = node;
		this.lengthOfList = 0;
	}
	
	@Override
	public void addNodeToStartOfList(Integer integer) {
		Node newStartNode = new NodeImpl(integer);
		
		startNode.setPreviousNode(newStartNode);
		
		newStartNode.setNextNode(startNode);
		newStartNode.setPreviousNode(endNode);
		
		this.startNode = newStartNode;
		lengthOfList++;
	}

	@Override
	public void addNodeToEndOfList(Integer integer) {
		Node newEndNode = new NodeImpl(integer);
		
		endNode.setNextNode(newEndNode);
		
		newEndNode.setPreviousNode(endNode);
		newEndNode.setNextNode(startNode);
		
		this.endNode = newEndNode;
		lengthOfList++;

	}

	@Override
	public void removeNodeFromList(Integer indexOfIntegerToBeRemoved) {
		
		if (indexOfIntegerToBeRemoved == 0) {
			System.out.println(indexOfIntegerToBeRemoved);
			startNode.getNextNode().setPreviousNode(endNode);
			endNode.setNextNode(startNode.getNextNode());
			lengthOfList--;
		}
		if (indexOfIntegerToBeRemoved == lengthOfList) {
			endNode.getPreviousNode().setNextNode(startNode);
			startNode.setPreviousNode(endNode.getPreviousNode());
			lengthOfList--;
		}
		else {
			Node node = startNode;
			for (int x = 0; x <= indexOfIntegerToBeRemoved.intValue(); x++) {
				if (x == indexOfIntegerToBeRemoved.intValue()) {
					node.getNextNode().setPreviousNode(node.getPreviousNode());
					node.getPreviousNode().setNextNode(node.getNextNode());
				}
				node = node.getNextNode();
			}
		}
	}
	
	public Node getStartNode() {
		return startNode;
	}

	public Node getEndNode() {
		return endNode;
	}
}