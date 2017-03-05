/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q124 {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
        findMax(root, 0);
        return max;
    }
    public int findMax(TreeNode root, int cur){
        if(root==null)
            return 0;
        int left = Math.max(findMax(root.left,cur),0);
        int right = Math.max(findMax(root.right,cur),0);
        max = Math.max((root.val+left+right),max);
        return Math.max(left,right)+root.val;
    }
}
