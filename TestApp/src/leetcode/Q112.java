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
        return dfs(root, sum);
    }
    public boolean dfs(TreeNode root, int sum){
        if(root==null)
            return false;
        if(root.left==null && root.right==null){
            sum-=root.val;
            if(sum==0)
                return true;
            return false;
        }
        sum-= root.val;
        return dfs(root.left, sum) || dfs(root.right, sum);
    }
}
