package demo;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Graph {
	
	private Set<Node> nodes;
	
	public Graph() {
		nodes = new HashSet<Node>();
	}
	
	private class Node {
		
		private int id;
		private Set<Node> directChildren;

		public Node(int id) {
			this.id = id;
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || this.getClass() != o.getClass()) return false;
			Node other = (Node) o;
			return this.id == other.id;
		}
		
		@Override
		public int hashCode() {
			return id;
		}
		
		@Override
		public String toString() {
			return "Node "+id;
		}
		
		public void addChild(Node n) {
			if (this == n) {
				throw new IllegalArgumentException("Cannot add node "+n.id+" as a child of itself.");
			}
			directChildren.add(n);
		}
		
		public void removeChild(Node n) {
			directChildren.remove(n);
		}
		
	}
	
	public Node addNode(int id) {
		Node n = new Node(id);
		nodes.add(n);
		return n;
	}
	
	public boolean containsNode(int id) {
		return nodes.contains(new Node(id));
	}
	
	public Node getNode(int id) {
		for (Node n : nodes) {
			if (n.id == id) return n;
		}
		return null;
	}
	
	public void connect(int id1, int id2) {
		if (id1==id2) throw new IllegalArgumentException("Cannot connect node to itself.");
		boolean containsId1 = this.containsNode(id1);
		boolean containsId2 = this.containsNode(id2);
		if (!containsId1 && !containsId2)
			throw new NoSuchElementException(
					"Graph does not contain nodes with ids "+id1+" and "+id2);
		if (!containsId1)
			throw new NoSuchElementException(
					"Graph does not contain node with id "+id1);
		if (!containsId2)
			throw new NoSuchElementException(
					"Graph does not contain node with id "+id2);
		Node n1 = getNode(id1);
		Node n2 = getNode(id2);
		n1.addChild(n2);
		n2.addChild(n1);
	}
	
	public void disconnect(int id1, int id2) {
		if (id1==id2) throw new IllegalArgumentException("Cannot disconnect node from itself.");
		boolean containsId1 = this.containsNode(id1);
		boolean containsId2 = this.containsNode(id2);
		if (!containsId1 && !containsId2)
			throw new NoSuchElementException(
					"Graph does not contain nodes with ids "+id1+" and "+id2);
		if (!containsId1)
			throw new NoSuchElementException(
					"Graph does not contain node with id "+id1);
		if (!containsId2)
			throw new NoSuchElementException(
					"Graph does not contain node with id "+id2);
		Node n1 = getNode(id1);
		Node n2 = getNode(id2);
		n1.removeChild(n2);
		n2.removeChild(n1);
	}

}
