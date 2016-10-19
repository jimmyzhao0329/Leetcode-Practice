// https://leetcode.com/problems/clone-graph/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }
    
    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map){
        if(node == null){
            return node;
        }
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node.label, cloned);
        for(UndirectedGraphNode neighbor : node.neighbors){
            cloned.neighbors.add(helper(neighbor, map));
        }
        return cloned;
    }
}