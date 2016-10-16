public class binary_tree_to_doubly_linked_list{
	public static TreeNode bt_to_dll(TreeNode root){
		if(root == null){
			return res;
		}
		if(root.left != null){
			TreeNode left = bt_to_dll(root.left);
			for( ; left.right != null; left = left.right);
			left.right = root;
			root.left = left;
		}

		if(root.right != null){
			TreeNode right_list = bt_to_dll(root.right);
			for( ; right.left != null; right = right.left);
			right.left = root;
			root.right = right;
		}
		return root;
	}
}