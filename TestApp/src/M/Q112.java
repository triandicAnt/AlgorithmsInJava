/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        return hasSum(root, sum);
    }
    public boolean hasSum(TreeNode root, int sum){
        if(root==null)
            return false;
        if(root.left==null && root.right==null)
            return root.val-sum==0;
        return hasSum(root.left, sum-root.val) || hasSum(root.right, sum-root.val);
    }
}
