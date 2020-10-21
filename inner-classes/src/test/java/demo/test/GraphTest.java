package demo.test;

import org.junit.jupiter.api.Test;

import demo.graph.Graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class GraphTest {
	
	static Graph g1;
	static Graph g2;
	
	@BeforeAll
	static void setup() {
		g1 = new Graph(0, 1, 2, 3, 4, 5);
		g1.connect(0, 1);
		g1.connect(1, 2);
		g1.connect(1, 3);
		g1.connect(3, 4);
		/*
		 * 0--1--2
		 *     \
		 *      3--4  5
		 */
		g2 = new Graph(0, 1, 2, 3, 4, 5);
		g2.connect(0, 1);
		g2.connect(1, 2);
		g2.connect(1, 3);
		g2.connect(3, 4);
		g2.connect(4, 2);
		/*
		 * 0--1--2
		 *     \  \
		 *      3--4  5
		 */
	}

	@Test
	void testDFS_noLoops() {
		Assertions.assertTrue(g1.hasPathDFS(0, 4));
		Assertions.assertFalse(g1.hasPathDFS(0, 5));
	}

	@Test
	void testDFS_loops() {
		Assertions.assertTrue(g2.hasPathDFS(0, 4));
		Assertions.assertFalse(g2.hasPathDFS(0, 5));
	}

	@Test
	void testBFS_noLoops() {
		Assertions.assertTrue(g1.hasPathBFS(0, 4));
		Assertions.assertFalse(g1.hasPathBFS(0, 5));
	}

	@Test
	void testBFS_loops() {
		Assertions.assertTrue(g2.hasPathBFS(0, 4));
		Assertions.assertFalse(g2.hasPathBFS(0, 5));
	}

}
