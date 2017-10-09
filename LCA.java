
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
}
