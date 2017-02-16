/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q297 {
    String seperator = ",";
    String nullNode = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        preOrder(sb,root);
        return sb.toString();
    }
    public void preOrder(StringBuffer sb, TreeNode root){
        if(root==null)
            sb.append("X").append(",");
        else{
            sb.append(root.val).append(",");
            preOrder(sb,root.left);
            preOrder(sb,root.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0)
            return null;
        Deque<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return buildTree(q);
    }
    public TreeNode buildTree(Deque<String> q){
        String s = q.poll();
        if(s.equals("X")){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(s));
            node.left = buildTree(q);
            node.right = buildTree(q);
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
