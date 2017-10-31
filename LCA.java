import java.util.ArrayList;
import java.util.List;






public class LCA
{
 /*
    Node r;
    private List<Integer> path1 = new ArrayList<>();  
    private List<Integer> path2 = new ArrayList<>();
 
   int findLCA(int no1, int no2) {
        path1.clear();
        path2.clear();
        return findLCA(r, no1, no2);
    }
 */
    private int findLCA(ArrayList<Node> arrList, Node a, Node b) {
    	
    	if(arrList == null || a == null || b == null || arrList.size() == 0 ||!arrList.contains(a) || !arrList.contains(b) || !isAcyclic(arrList)){
    		return -1;
    	}
    	ArrayList<Node> roots = new ArrayList<Node>();
    	ArrayList<Node> ancestorList1 = new ArrayList<Node>();
    	ArrayList<Node> ancestorList2 = new ArrayList<Node>();
    	ArrayList<Node> commonAncestors = new ArrayList<Node>();
    	for(int index = 0; index < arrList.size(); index++)
        {
        	if(arrList.get(index).in == 0)
        	{
        		Node n= arrList.get(index);
        		roots.add(n);
        	}
        }
    	 ancestorList1.add(a);
	     ancestorList2.add(b);
	        for(int i = 0; i < roots.size(); i++)
	        {
	        	compareAncestors(roots.get(i), ancestorList1, ancestorList2);
	        }
	   
    }
 
    private boolean findPath(Node r, int n, List<Integer> path)
    {
       
    }
    public static ArrayList<Node> compare(ArrayList<Node> list1, ArrayList<Node> list2) {
		ArrayList<Node> listOfSameNodes = new ArrayList<Node>();
        for (int index=0; index<list1.size(); index++) {
        	Node n = list1.get(index);
            if(list2.contains(n)) {
                listOfSameNodes.add(n);
            }
        }

        return listOfSameNodes;
    }
    private static boolean cycle(ArrayList<Node> arrList, Node temp, ArrayList<Node> visited, ArrayList<Node> stack, boolean cycle)
	{
		visited.add(temp);
		stack.add(temp);
		int tempLength= temp.edges.size();
		for(int index = 0; index < tempLength; index++)
		{
			Node n = (Node) temp.edges.get(index);
			boolean nInVisited= visited.contains(n);
			boolean nInStack= stack.contains(n);
			if(!nInVisited) 
			{
				cycle = cycle || cycle(arrList, n, visited, stack, cycle);
			}
			else if(nInStack)
			{
				cycle = true;
				return cycle;
			}
		}
		stack.remove(temp);
		return cycle;
	}
    public static boolean isAcyclic(ArrayList<Node> arrList)
    {
		if(arrList == null){
			return true;
		}
		for(int index = 0; index < arrList.size(); index++)
		{
			ArrayList<Node> stack = new ArrayList<Node>();
			ArrayList<Node> visited = new ArrayList<Node>();
			Node current = arrList.get(index);
			boolean cycle= false;
			cycle = cycle(arrList, current, visited, stack, cycle);
			if(cycle)
			{
				return false;
			}
		}
        return true;
    }
    public static void compareAncestors(Node root, ArrayList<Node> ancestorList1, ArrayList<Node> ancestorList2)
    {
    	if(root.edges == null){
    		return;
    	}
    	
    	for(int index = 0; index < root.edges.size(); index++)
    	{
    		Node temp = (Node) root.edges.get(index);
    		if(!(ancestorList1.contains(temp) || ancestorList2.contains(temp))) {
    			compareAncestors(temp, ancestorList1, ancestorList2);
    		}
    		if(ancestorList1.contains(temp)) {
    			ancestorList1.add(root);
    		}
    		if(ancestorList2.contains(temp)) {
    			ancestorList2.add(root);	
    		}
    	}
    }
}