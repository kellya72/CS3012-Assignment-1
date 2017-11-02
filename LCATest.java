import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LCATest {

	@Test
	public void testFindLCA() {
		
		Node a = null;
		Node b= null;
		ArrayList<Node> list = new ArrayList<Node>();
		assertEquals("When nodes and list are null", null, LCA.findLCA(list,a ,b));
	    a= new Node("a",1);
	    assertEquals("When one node and list are null", null, LCA.findLCA(list,a ,b));
	    b= new Node("b",2);
	    a.connect(b);
	    assertEquals("When the list is null", null, LCA.findLCA(list,a ,b));
	    list.add(a);
	    list.add(b);
	    Node c= new Node("c",3);
	    a.connect(c);
	    /*
	  			A
	  		/      \
	  	   B        C
	    */
	    assertEquals("When node is not in list", null, LCA.findLCA(list,a ,c));
	    assertEquals("When node is not in list", null, LCA.findLCA(list,c ,b));
	    list.add(c);
	    Node d = new Node("d",4);
	    b.connect(d);
	    list.add(d);
	    /*
			A
		/      \
	   B        C
	  /
	D
*/
	    ArrayList<Node> lca = new ArrayList<Node>();
	    lca.add(a);
	    assertEquals("Only one LCA", lca, LCA.findLCA(list, b, c));
	    assertEquals("Only one LCA", lca, LCA.findLCA(list, d, c));
	    assertEquals("When one of the given nodes is the LCA", lca, LCA.findLCA(list, a, c));
	    Node e = new Node("e",5);
	    b.connect(e);
	    list.add(e);
	    /*
		A
	/      \
   B        C
  / \
D    E
*/
	    lca.remove(a);
	    lca.add(b);
	    assertEquals("When LCA is not the root", lca, LCA.findLCA(list, d, e));
	    Node f = new Node("f",6);
	    f.connect(d);
	    f.connect(e);
	    list.add(f);
	    lca.add(f);
	    assertEquals("When there is more than one LCA", lca, LCA.findLCA(list, d, e));
	    c.connect(a);
	    assertEquals("When graph is a cycle", null, LCA.findLCA(list, d, e));

	}
	@Test
	public void testIsAcyclical(){
		ArrayList<Node> list = null;
		assertEquals("Testing when list is empty", true, LCA.isAcyclic(list));
	}
	
}
