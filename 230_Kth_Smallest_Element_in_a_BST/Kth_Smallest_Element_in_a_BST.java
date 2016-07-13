// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode node = root;
        int count = 0;
        while(!st.isEmpty() || node != null){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                node = st.pop();
                count++;
                if(count == k){
                    return node.val;
                }
                node = node.right;
            }
        }
        return node.val;
    }
}