/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return symmetric(root.left, root.right);
    }
    public boolean symmetric(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return symmetric(left.left,right.right) && symmetric(left.right,right.left);
    }
    
}
