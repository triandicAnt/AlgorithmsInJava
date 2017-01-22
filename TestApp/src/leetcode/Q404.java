/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q404 {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
            return 0;
        // if(root.left==null && root.right==null)
        //     return root.val;
        // return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        int ans= 0;
        if(root.left!=null){
            if(root.left.left==null && root.left.right==null)
                ans+=root.left.val;
            else
                 ans += sumOfLeftLeaves(root.left);
        }
        if(root.right!=null)
             ans += sumOfLeftLeaves(root.right);
        return ans;
    }
}
