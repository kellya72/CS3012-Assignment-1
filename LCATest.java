import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void testFindLCA() {
		LCA testTree = new LCA();
        assertSame("Checking for correct lowest common ancestor when tree is empty", -1, testTree.findLCA(4,5));		
        testTree.r = new Node(1);
        testTree.r.left = new Node(2);
        testTree.r.right = new Node(3);
        testTree.r.left.left = new Node(4);
        testTree.r.left.right = new Node(5);
        testTree.r.right.left = new Node(6);
        testTree.r.right.right = new Node(7);
        assertSame("Checking for correct lowest common ancestor", 22, testTree.findLCA(4,5));
	}

}
