// https://leetcode.com/problems/minimum-height-trees/

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        
        List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
        for(int i = 0; i < n; i++){
            adj.add(new HashSet<Integer>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            if(adj.get(i).size() == 1 ){
                leaves.add(i);
            }
        }
        
        while(n > 2){
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for(int i : leaves){
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if(adj.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        
        return leaves;
    }
}