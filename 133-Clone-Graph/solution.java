/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    Map<UndirectedGraphNode, UndirectedGraphNode> gMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        if(gMap.containsKey(node))
            return gMap.get(node);
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.val);
        for(UndirectedGraphNode neig : node.neighbors)
        {
            newNode.neighbors.add(cloneGraph(neig));
        }
        return newNode;
    }
}