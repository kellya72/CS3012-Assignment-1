import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;







public class LCA
{
    private String findLCA(ArrayList<Node> arrList, Node a, Node b) {
    	
    	if(arrList == null || a == null || b == null || arrList.size() == 0 ||!arrList.contains(a) || !arrList.contains(b) || !isAcyclic(arrList)){
    		return null;
    	}
    	ArrayList<Node> roots = new ArrayList<Node>();
    	ArrayList<Node> ancestorList1 = new ArrayList<Node>();
    	ArrayList<Node> ancestorList2 = new ArrayList<Node>();
    	ArrayList<Node> ancestorsShared = new ArrayList<Node>();
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
	     ancestorsShared = compare(ancestorList1, ancestorList2);
	     if(ancestorsShared.size() == 0){
	    	 return null;
	     }
	     while(ancestorsShared.size() != 1)
	        {
	        	for(int index = 0; index < ancestorsShared.size(); index++)
	        	{
	        		
	        		if(check(ancestorsShared))
	            	{
	            		return listToString(ancestorsShared);
	            	}
	        		//if its descendants are in the list of common ancestors then remove it as the descendant is a lower common ancestor
	            	else
	            	{
	            		if(compare(ancestorsShared, ancestorsShared.get(index).edges).size() != 0)
	            		{
	            			ancestorsShared.remove(index);
	            		}
	            	}
	        	}	
	        }
	        return listToString(ancestorsShared);  
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
    private static boolean check(ArrayList<Node> ancestorsShared) 
    {
		for(int index = 0; index < ancestorsShared.size(); index++)
		{
			Node temp = ancestorsShared.get(index);
			ArrayList<Node> tempNodes = temp.edges;
			if(compare(ancestorsShared, tempNodes).size() != 0)
    		{
    			return false;
    		}
		}
		return true;
	}
    private String listToString(ArrayList<Node> list){
    	String listString = list.stream().map(Object::toString).collect(Collectors.joining(", "));
    	return listString;
    }

}