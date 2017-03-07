/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q513 {
    public int findBottomLeftValue(TreeNode root) {
        if(root==null)
            return -1;
        Queue<TreeNode> q = new LinkedList<>();
        int res = 0;
        q.add(root);
        while(!q.isEmpty()){
            int s = q.size();
            for(int i = 0 ;i<s;i++){
                TreeNode temp = q.poll();
                if(i==0)
                    res = temp.val;
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
        }
        return res;
    }
}
