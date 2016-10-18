// https://instant.1point3acres.com/thread/188903

public class flip_leaf {
	public static void flip(TreeNode child){
		
		while(child != null){
			child.val ^= 1;
			if(child.parent != null){
				if(child.parent.left == child){
					if(child.parent.right.val == 0) break;
				}
				else{
					if(child.parent.left.val == 0) break;
				}
			}
			child = child.parent;
		}
	}
}