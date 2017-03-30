/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q337 {
    // public int rob(TreeNode root) {
    //     if(root==null)
    //         return 0;
    //     int val = 0;
    //     if(root.left!=null)
    //         val+=(rob(root.left.left) + rob(root.left.right));
    //     if(root.right!=null)
    //         val+=(rob(root.right.left)+rob(root.right.right));
    //     return Math.max(val+root.val, rob(root.left)+rob(root.right));
        
    // }
    public int rob(TreeNode root){
        if(root==null)
            return 0;
        int []a = robNode(root);
        return Math.max(a[0],a[1]);
    }
    public int[]robNode(TreeNode root){
        if(root==null)
            return new int[2];
        int [] left = robNode(root.left);
        int []right = robNode(root.right);
        int []a = new int[2];
        a[0] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        a[1] = root.val + left[0] + right[0];
        return a;
    }
}
