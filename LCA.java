import BST.Node;

public class LCA {
public static class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data)
	{
		this.data = data;
	}
}
public static TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b){
	while(root!= null){
		if(root.data>a.data && root.data>b.data){
			root=root.left;
		}
		if(root.data<a.data && root.data<b.data){
			root=root.right;
		}
		else{
			return root;
		}
	}
	return root;
}
private TreeNode put(TreeNode x, int val) {
    if (x == null) return new TreeNode(val);
    if      (val < x.data) x.left  = put(x.left, val);
    else if (val > x.data) x.right = put(x.right,val);
    else              x.data   = val;
    return x;
}

}
