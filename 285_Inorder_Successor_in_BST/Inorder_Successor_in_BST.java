public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	if(root == null || p == null){
            return null;
        }
        TreeNode res = null
        if(p.right != null){
            // find its left most node 
            res = p.right;
            while(res.left != null){
                res = res.left;
            }
            return res;
        }
        //if p doesn't have right subtree
        while(root != null){
            if(root.val > p.val){
                res = root;
                root = root.left;
            }
            else if(root.val < p.val){
                root = root.right;
            }
            else {
                break;
            }
        }
        return res;
    }
}