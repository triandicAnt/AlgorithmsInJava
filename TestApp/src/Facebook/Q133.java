/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Q133 {
    Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return node;
        if(map.containsKey(node.label))
            return map.get(node.label);
        UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
        map.put(node.label,cloned);
        for(UndirectedGraphNode n : node.neighbors){
            cloned.neighbors.add(cloneGraph(n));
        }
        return cloned;
    }
}
