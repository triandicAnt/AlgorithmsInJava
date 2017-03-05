/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q114 {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        /*
        while(root!=null){
            //check if left is null or not
            if(root.left!=null){
                // find the rightmost of left Node
                TreeNode rightMost = root.left;
                while(rightMost.right!=null){
                    rightMost = rightMost.right;
                }
                rightMost.right = root.right;
                root.right = root.left;
                root.left = null;
            }else{
                root = root.right;
            }
        }*/
        postOrder(root);
    }
    
     void postOrder(TreeNode root){
         if(root==null)
            return;
         postOrder(root.right);
         postOrder(root.left);
         root.right = prev;
         root.left=null;
         prev= root;
     }
}
