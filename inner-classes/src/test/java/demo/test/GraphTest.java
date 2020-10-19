package demo.test;

import java.util.Arrays;
import java.util.HashSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import demo.Graph;

class GraphTest {

	@Test
	void testDFS_noLoops() {
		Graph g = new Graph(new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5)));
		g.connect(0, 1);
		g.connect(1, 2);
		g.connect(1, 3);
		g.connect(3, 4);
		/*
		 * 0--1--2
		 *     \
		 *      3--4  5
		 */
		Assertions.assertTrue(g.hasPathDFS(0, 4));
		Assertions.assertFalse(g.hasPathDFS(0, 5));
	}

	@Test
	void testDFS_loops() {
		Graph g = new Graph(new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5)));
		g.connect(0, 1);
		g.connect(1, 2);
		g.connect(1, 3);
		g.connect(3, 4);
		g.connect(4, 2);
		/*
		 * 0--1--2
		 *     \  \
		 *      3--4  5
		 */
		Assertions.assertTrue(g.hasPathDFS(0, 4));
		Assertions.assertFalse(g.hasPathDFS(0, 5));
	}

	@Test
	void testBFS_noLoops() {
		Graph g = new Graph(new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5)));
		g.connect(0, 1);
		g.connect(1, 2);
		g.connect(1, 3);
		g.connect(3, 4);
		/*
		 * 0--1--2
		 *     \
		 *      3--4  5
		 */
		Assertions.assertTrue(g.hasPathBFS(0, 4));
		Assertions.assertFalse(g.hasPathBFS(0, 5));
	}

	@Test
	void testBFS_loops() {
		Graph g = new Graph(new HashSet<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5)));
		g.connect(0, 1);
		g.connect(1, 2);
		g.connect(1, 3);
		g.connect(3, 4);
		g.connect(4, 2);
		/*
		 * 0--1--2
		 *     \  \
		 *      3--4  5
		 */
		Assertions.assertTrue(g.hasPathBFS(0, 4));
		Assertions.assertFalse(g.hasPathBFS(0, 5));
	}

}
