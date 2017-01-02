/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q222 {
    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        //return dfs(root);
        TreeNode left = root.left;
        TreeNode right = root.right;
        int h = 1;
        while(right!=null){
            left = left.left;
            right = right.right;
            h++;
        }
        //System.out.println(h);
        if(left==null)
            return (1<<h) -1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    public int dfs(TreeNode root){
        if(root==null)
            return 0;
        int count = 1;
        count+=dfs(root.left);
        count+=dfs(root.right);
        return count;
    }
    
}
