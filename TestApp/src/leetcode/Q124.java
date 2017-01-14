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
public class Q124 {
    int max =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return 0;
       // int max = 0;
        //int []path = new int[100];
       // dfs(root,path,0);
        maxPath(root);
        return max;
    }
    public void dfs(TreeNode root, int []path, int l){
        if(root==null)
            return;
        path[l]= root.val;
        int curSum = 0;
        for(int i=l;i>=0;i--){
            curSum+=path[i];
            if(curSum>max)
                max = curSum;
        }
        dfs(root.left,path,l+1);
        dfs(root.right,path,l+1);
    }
    public int maxPath(TreeNode root){
        if(root==null)
            return 0;
        int left = Math.max(0,maxPath(root.left));
        int right = Math.max(0,maxPath(root.right));
        max = Math.max(left+right+root.val, max);
        return Math.max(left,right) + root.val;
    }
}