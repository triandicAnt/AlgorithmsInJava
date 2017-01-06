/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Q133 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null)
            return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        return dfs(node, map);
    }
    public UndirectedGraphNode dfs(UndirectedGraphNode node , Map<Integer, UndirectedGraphNode> map){
        if(node == null)
            return null;
        if(map.containsKey(node.label)){
            return map.get(node.label);
        }
        else{
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            map.put(node.label, newNode);
            for(int i = 0; i< node.neighbors.size();i++){
                newNode.neighbors.add(dfs(node.neighbors.get(i),map));
            }
            return newNode;
        }
    }
}
