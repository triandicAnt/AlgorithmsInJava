/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
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
        if(root==null ||(root.left==null && root.right==null))
            return true;
        // if(root.left.val!=root.right.val)
        //     return false;
        return symmetric( root.left,  root.right);
    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right==null)
            return true;
        if((left==null && right !=null) || (left!=null && right ==null))
            return false;
        if(left.val!=right.val)
            return false;
        // if((left.left==null && right.left!=null) ||
        //     (left.right==null && right.right!=null) ||
        //     (left.left!=null && right.left==null) ||
        //     (left.right!=null && right.right==null))
        //     return false;
        if((left.left!=null && right.right!=null) && (left.left.val!=right.right.val))
            return false;
        if((left.right!=null && right.left!=null) && (left.right.val!= right.left.val))
            return false;
        if(!(isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left)))
            return false;
        return true;
    }
    public boolean symmetric(TreeNode left, TreeNode right){
        if(left==null || right==null)
            return left==right;
        if(left.val!=right.val)
            return false;
        return symmetric(left.left,right.right) && symmetric(left.right, right.left);
    }
}