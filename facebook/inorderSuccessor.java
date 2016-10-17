public class inorderSuccessor {
	public static TreeNode successor(Treenode root, TreeNode p){
		TreeNode succ = null;
		if(p.right != null){
			succ = p.right;
			while(succ.left != null){
				succ = succ.left;
			}
			return succ;
		}
		else{
			while(root != null){
				if(root.val > p.val){
					succ = root;
					root = root.left;
				}
				else if(root.val < p.val){
					root = root.right;
				}
				else{
					break;
				}
			}
		}
		return succ;
	}
}