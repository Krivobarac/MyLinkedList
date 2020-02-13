package myLinkedList;
import java.util.Iterator;

public class MyLinkedList<T> implements ILinkedList<T> {
	private Node member;
	private Node root;
	
	private final class Node implements Iterator<Node> {
		private T value;
		private Node next;
		private Node previous;
		
		private Node(T value) {
			this.value = value;
		}
		
		private boolean hasPrevious() {
			if(this.previous != null) return true;
			return false;
		}

		public boolean hasNext() {
			if(this.next != null) return true;
			return false;
		}
		
		public Node next() {
			return this.next;
		}
		
	}
	
	public boolean add(T value) {
		Node node = new Node(value);
		
		if(this.member == null) {
			this.member = node;
			this.root = this.member;
			return true;
		} else if(this.member != null) {
			this.member.next = node;
			node.previous = this.member;
			this.member = node;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void showAll() {
		Node tempNode = this.root;
		
		while(tempNode != null) {
			System.out.println(tempNode.value);
			tempNode = tempNode.next;
		}
	}

	@Override
	public boolean addAt(T value, int index) {
		Node tempNode = this.root;
		int i = 1;
		while(tempNode != null) {
			if(i == index) {
				Node newNode = new Node(value);
				newNode.next = tempNode;
				newNode.previous = tempNode.previous;
				
				if(tempNode.previous != null) {
					
					tempNode.previous.next = newNode;
				} else {
					this.root = newNode;
				}
				tempNode.previous = newNode;
				return true;
			}
			i++;
			tempNode = tempNode.next;
		}
		return false;
	}

	@Override
	public T getAt(int index) {
		Node tempNode = this.root;
		int i = 1;
		while(tempNode != null) {
			if(i == index)
			return tempNode.value;
			i++;
			tempNode = tempNode.next;
		}
		return null;
	}

	@Override
	public boolean updateAt(T value, int index) {
		Node tempNode = this.root;
		int i = 1;
		while(tempNode != null) {
			if(i == index) {
				tempNode.value = value;
				return true;
			}
			i++;
			tempNode = tempNode.next;
		}
		return false;
	}

	@Override
	public boolean deleteAt(int index) {
		Node tempNode = this.root;
		int i = 1;
		while(tempNode != null) {
			if(i == index) {
				if(tempNode.hasNext()) {
					tempNode.next.previous = tempNode.previous;
				} else {
					this.member = tempNode.previous;
				}
				if(tempNode.hasPrevious()) {
					tempNode.previous.next = tempNode.next;
				} else {
					this.root = tempNode.next;
				}
				tempNode.next = null;
				tempNode.previous = null;
				tempNode = null;
				return true;
			}
			i++;
			tempNode = tempNode.next;
		}
		return false;
	}
}
