/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q285 {

    public TreeNode inorderSuccessor(TreeNode root, int data){
        if(root==null)
            return root;
        TreeNode cur = find(root, data);
        if(cur.right!=null)
            return findMin(cur.right);
        TreeNode anc = root;
        TreeNode suc = null;
        while(anc!=cur){
            if(anc.val>cur.val){
                suc = anc;
                anc = anc.left;
            }else
                anc = anc.right;
        }
        return suc;
    }
    
    public TreeNode findMin(TreeNode root){
        if(root==null)
            return null;
        while(root.left!=null)
            root = root.left;
        return root;
    }
    public TreeNode find(TreeNode root, int data){
        if(root==null)
            return null;
        if(root.val == data)
            return root;
        if(root.val<data)
            return find(root.right, data);
        else
            return find(root.left, data);
    }
}
