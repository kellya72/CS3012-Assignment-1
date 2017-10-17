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
    	int number = 0;
        if (!findPath(r, no1, path1) || !findPath(r, no2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }
 
        int index;
        for (index = 0; index < path1.size() && index < path2.size(); index++) {
          //  System.out.println(path1.get(i) + " " + path2.get(i));
            if (!path1.get(index).equals(path2.get(index)))
                number=index-1;
            	break;
        }
 
        return path1.get(number);
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
 
    public static void main(String[] args)
    {
        LCA tree = new LCA();
        tree.r = new Node(1);
        tree.r.left = new Node(2);
        tree.r.right = new Node(3);
        tree.r.left.left = new Node(4);
        tree.r.left.right = new Node(5);
        tree.r.right.left = new Node(6);
        tree.r.right.right = new Node(7);
 
        System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4));
       /* System.out.println("LCA(4, 7): " + tree.findLCA(4,7));
        System.out.println("LCA(4, 8): " + tree.findLCA(4,8));
        System.out.println("LCA(1, 1): " + tree.findLCA(1,1)); */
    }
}