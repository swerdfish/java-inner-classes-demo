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
	void testDFS_noLoops_0to4() {
		Assertions.assertTrue(g1.hasPathDFS(0, 4));
	}
	
	@Test
	void testDFS_noLoops_0to5() {
		Assertions.assertFalse(g1.hasPathDFS(0, 5));
	}

	@Test
	void testDFS_loops_0to4() {
		Assertions.assertTrue(g2.hasPathDFS(0, 4));
	}
	
	@Test
	void testDFS_loops_0to5() {
		Assertions.assertFalse(g2.hasPathDFS(0, 5));
	}

	@Test
	void testBFS_noLoops_0to4() {
		Assertions.assertTrue(g1.hasPathBFS(0, 4));
	}
	
	@Test
	void testBFS_noLoops_0to5() {
		Assertions.assertFalse(g1.hasPathBFS(0, 5));
	}

	@Test
	void testBFS_loops_0to4() {
		Assertions.assertTrue(g2.hasPathBFS(0, 4));
	}
	
	@Test
	void testBFS_loops_0to5() {
		Assertions.assertFalse(g2.hasPathBFS(0, 5));
	}
	
	@Test
	void testBFSlength_noLoops_0to4() {
		Assertions.assertEquals(3, g1.lengthPathBFS(0, 4));
	}
	
	@Test
	void testBFSlength_noLoops_2to4() {
		Assertions.assertEquals(3, g1.lengthPathBFS(2, 4));
	}
	
	@Test
	void testBFSlength_noLoops_0to5() {
		Assertions.assertEquals(-1, g1.lengthPathBFS(0, 5));
	}
	
	@Test
	void testBFSlength_loops_0to4() {
		Assertions.assertEquals(3, g2.lengthPathBFS(0, 4));
	}
	
	@Test
	void testBFSlength_loops_2to4() {
		Assertions.assertEquals(1, g2.lengthPathBFS(2, 4));
	}
	
	@Test
	void testBFSlength_loops_0to5() {
		Assertions.assertEquals(-1, g2.lengthPathBFS(0, 5));
	}

}
