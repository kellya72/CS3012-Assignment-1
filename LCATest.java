import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LCATest {

	@Test
	public void testFindLCA() {
		/*LCA testTree = new LCA();
        assertSame("Checking for correct lowest common ancestor when tree is empty", -1, testTree.findLCA(3,2));		
        testTree.r = new Node(1);
        assertSame("Checking for correct lowest common ancestor when tree contains one node", 1, testTree.findLCA(1,1));	
        testTree.r.left = new Node(2);
        assertSame("Checking for correct lowest common ancestor when tree contains two nodes", 1, testTree.findLCA(1,2));
        assertSame("Checking for correct lowest common ancestor when tree does not contain either nodes", -1, testTree.findLCA(3,4));		
        assertSame("Checking for correct lowest common ancestor when tree does not contain one of the nodes", -1, testTree.findLCA(11,2));		
        assertSame("Checking for correct lowest common ancestor when tree does not contain one of the nodes", -1, testTree.findLCA(1,6));		
        testTree.r.right = new Node(3);
        assertSame("Checking for correct lowest common ancestor",1, testTree.findLCA(2,3));       
        testTree.r.left.left = new Node(4);
        assertSame("Checking for correct lowest common ancestor",2, testTree.findLCA(2,4));
        testTree.r.left.right = new Node(5);
        testTree.r.right.left = new Node(6);
        testTree.r.right.right = new Node(7);
        assertSame("Checking for correct lowest common ancestor",2, testTree.findLCA(4,5));
        assertSame("Checking for correct lowest common ancestor",3, testTree.findLCA(6,7)); 
        assertSame("Checking for correct lowest common ancestor",3, testTree.findLCA(3,6));
        assertSame("Checking for correct lowest common ancestor",3, testTree.findLCA(3,7));
        assertSame("Checking for correct lowest common ancestor",-1, testTree.findLCA(8,5));
        assertSame("Checking for correct lowest common ancestor",-1, testTree.findLCA(8,7));
        assertSame("Checking for correct lowest common ancestor",-1, testTree.findLCA(4,9));
       */ 
		Node a = null;
		Node b= null;
		ArrayList<Node> list = new ArrayList<Node>();
		assertEquals("When nodes and list are null", null, LCA.findLCA(list,a ,b));
	    a= new Node("a",1);
	    assertEquals("When one node and list are null", null, LCA.findLCA(list,a ,b));
	    b= new Node("b",2);
	    assertEquals("When the list is null", null, LCA.findLCA(list,a ,b));
	}
	@Test
	public void testCompare(){
		
	}
	@Test
	public void testCycle(){
		
	}
	@Test
	public void testIsAcyclical(){
		
	}
	@Test
	public void testCompareAncestors(){
		
	}
	@Test
	public void testCheck(){
		
	}
	@Test
	public void testListToString(){
		
	}
}
