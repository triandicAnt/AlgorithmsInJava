package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q110 {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        if(Math.abs(lDepth-rDepth)>1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int depth(TreeNode root){
        if(root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        return (left==0||right==0)?left+right+1:Math.max(left,right)+1;
    }
}
