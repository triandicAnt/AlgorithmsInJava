/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
            return list;
        Stack<TreeNode> s = new Stack<>();
        while(true){
            while(root!=null){
                s.push(root);
                root=root.left;
            }
            if(s.isEmpty())
                break;
            root = s.pop();
            list.add(root.val);
            root= root.right;
        }
      return list;
    }
}
