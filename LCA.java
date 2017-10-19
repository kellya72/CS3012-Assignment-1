import java.util.ArrayList;
import java.util.List;
 


public class LCA
{
 
    Node r;
    private List<Integer> path1 = new ArrayList<>();  
    private List<Integer> path2 = new ArrayList<>();
 
   int findLCA(int no1, int no2) {
        path1.clear();
        path2.clear();
        return findLCA(r, no1, no2);
    }
 
    private int findLCA(Node r, int no1, int no2) {
    	//int number = 0;
        if (!findPath(r, no1, path1) || !findPath(r, no2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }
 
        int index;
        for (index = 0; index < path1.size() && index < path2.size(); index++) {
          //  System.out.println(path1.get(i) + " " + path2.get(i));
            if (!path1.get(index).equals(path2.get(index)))
            	break;
        }
 
        return path1.get(index-1);
    }
 
    private boolean findPath(Node r, int n, List<Integer> path)
    {
        if (r == null) {
            return false;
        }
 
        path.add(r.data);
 
        if (r.data == n) {
            return true;
        }
 
        if (r.left != null && findPath(r.left, n, path)) {
            return true;
        }
 
        if (r.right != null && findPath(r.right, n, path)) {
            return true;
        }
 
        path.remove(path.size()-1);
 
        return false;
    }
}