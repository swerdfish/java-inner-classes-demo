package demo.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

public class Graph {
	
	private Set<Node> nodes;
	
	public Graph() {
		nodes = new HashSet<Node>();
	}
	
	public Graph(Set<Integer> nodeIds) {
		this();
		for (int ni : nodeIds) {
			nodes.add(new Node(ni));
		}
	}
	
	public Graph(List<Integer> nodeIds) {
		this(new HashSet<Integer>(nodeIds));
	}
	
	public Graph(int... nodeIds) {
		this(Arrays.stream(nodeIds).boxed().collect(Collectors.toSet()));
	}
	
	public Graph(Map<Integer, Set<Integer>> nodeIdsAndChildrenIds) {
		this(nodeIdsAndChildrenIds.keySet());
		for (Map.Entry<Integer, Set<Integer>> niaci : nodeIdsAndChildrenIds.entrySet()) {
			for (int cni : niaci.getValue()) {
				connect(niaci.getKey(), cni);
			}
		}
	}
	
	private class Node {
		
		private int id;
		private Set<Node> directChildren;

		public Node(int id) {
			this.id = id;
			directChildren = new HashSet<Node>();
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
		
		public Set<Node> getDirectChildren() {
			return directChildren;
		}
		
		public boolean DFS(int id2, Set<Integer> visited) {
			if (this.id == id2) return true;
			if (visited.contains(this.id)) return false;
			visited.add(this.id);
			for (Node n : this.directChildren) {
				if (n.DFS(id2, visited)) return true;
			}
			// did not find id, have not visited before, no more children to check
			return false;
		}
		
	}
	
	public boolean hasPathDFS(int id1, int id2) {
		Set<Integer> visited = new HashSet<>();
		return getNode(id1).DFS(id2, visited);
	}
	
	public boolean hasPathBFS(int id1, int id2) {
		Set<Integer> visited = new HashSet<>(Collections.singleton(id1));
		Deque<Node> queue = new ArrayDeque<>();
		queue.addAll(getNode(id1).directChildren);
		while (queue.size() > 0) {
			Node n = queue.remove();
			if (n.id == id2) return true;
			if (visited.contains(n.id)) continue;
			visited.add(n.id);
			queue.addAll(n.directChildren);
		}
		return false;
	}
	
	public int lengthPathBFS(int id1, int id2) {
		// create immutable inner class BFO (breadth-first object)
		class BFO {
			int id;
			int length;
			BFO(int id) {
				this.id = id;
				this.length = 0;
			}
			BFO(int id, int length) {
				this.id = id;
				this.length = length;
			}
		}
		Set<Integer> visited = new HashSet<>();
		Deque<BFO> queue = new ArrayDeque<>();
		queue.add(new BFO(id1));
		while (queue.size() > 0) {
			BFO current = queue.remove();
			if (current.id == id2) return current.length;
			if (!visited.contains(current.id)) {
				visited.add(current.id);
				for (Node childNode : getNode(current.id).directChildren) {
					queue.add(new BFO(childNode.id, current.length+1));
				}
			}
		}
		return -1;
	}
	
	public Node addNode(int id) {
		Node n = new Node(id);
		nodes.add(n);
		return n;
	}
	
	public Node addNode(Node n) {
		nodes.add(n);
		return n;
	}
	
	public Set<Node> addNodes(int... idsToAdd) {
		nodes.addAll(
				Arrays.stream(idsToAdd)
				.mapToObj(id -> new Node(id))
				.collect(Collectors.toSet())
		);
		return nodes;
	}
	
	public Set<Node> addNodes(List<Integer> idsToAdd) {
		nodes.addAll(
				idsToAdd.stream()
				.mapToInt(Integer::intValue)
				.mapToObj(id -> new Node(id))
				.collect(Collectors.toSet())
		);
		return nodes;
	}
	
	public Set<Node> addNodes(Set<Integer> idsToAdd) {
		nodes.addAll(
				idsToAdd.stream()
				.mapToInt(Integer::intValue)
				.mapToObj(id -> new Node(id))
				.collect(Collectors.toSet())
		);
		return nodes;
	}
	
	public boolean containsNode(int id) {
		return nodes.contains(new Node(id));
	}
	
	private Node getNode(int id) {
		for (Node n : this.nodes) {
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
		if (n1==null && n2==null) {
			throw new RuntimeException("Could not fetch nodes "+id1+" and "+id2);
		}
		if (n1 == null) {
			throw new RuntimeException("Could not fetch node "+id1);
		}
		if (n2 == null) {
			throw new RuntimeException("Could not fetch node "+id2);
		}
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		System.out.println("Graph");
		for (Node n : nodes) {
			sb.append(n.toString()+": "+n.getDirectChildren()+'\n');
		}
		return sb.toString();
	}
	
	public Map<Integer, Set<Integer>> getGraphMap() {
		Map<Integer, Set<Integer>> graphMap = new HashMap<>();
		for (Node n : nodes) {
			graphMap.put(n.id, n.getDirectChildren().stream().map(d -> d.id).collect(Collectors.toSet()));
		}
		return graphMap;
	}

}
