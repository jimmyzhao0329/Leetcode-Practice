// Recursive
public class Solution {
    public int closestValue(TreeNode root, double target) {
    	TreeNode kid = (target < root.val) ? root.left : root.right;
    	if(kid == null){
    		return root.val;
    	}
    	int closest = closestValue(kid, target);
    	if(Math.abs(closest - target) < Math.abs(root.val - target)){
    		return closest;
    	} 
    	else{
    		return root.val;
    	}
    }
}


// Iterative
public class Solution {
    public int closestValue(TreeNode root, double target) {
    	int closest = root.val;
    	while(root != null){
    		root = (target < root.val) ? root.left : root.right;
    		if(Math.abs(closest - target) > Math.abs(root.val - target)){
    			closest = root.val;
    		}
    	}
    	return closest;
    }
}