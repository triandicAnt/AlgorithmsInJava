/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerializeDeserialize {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return null;
        StringBuffer sb = new StringBuffer();
        serialize(root,sb);
        return sb.toString();
    }
    public void serialize(TreeNode root, StringBuffer sb){
        if(root==null){
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length()==0)
            return null;
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(",")));
        return deserialize(q);
    }
    public TreeNode deserialize(Queue<String> q){
        if(q.size()==0)
            return null;
        String s = q.poll();
        if(s.equals("#"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
