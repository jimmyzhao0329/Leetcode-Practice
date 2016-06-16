// https://leetcode.com/problems/path-sum-ii/

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
    private void helper(List<List<Integer>> res, List<Integer> cur, TreeNode root, int sum){
        if(root == null){
            return;
        }
        cur.add(root.val);
        if(root.left == null && root.right == null && sum == root.val){
            res.add(new ArrayList<Integer>(cur));
        }
        helper(res, cur, root.left, sum - root.val);
        helper(res, cur, root.right, sum - root.val);
        cur.remove(cur.size() - 1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){
            return res;
        }
        helper(res, new ArrayList<Integer>(), root, sum);
        return res;
    }
}