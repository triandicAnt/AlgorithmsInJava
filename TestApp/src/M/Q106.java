/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q106 {
   // int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0 || postorder.length==0)
            return null;
        return build(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode build(int[] in, int[]post, int s, int e, int ps, int pe){
        if(s>e || ps>pe)
            return null;
        TreeNode root = new TreeNode(post[pe]);
        int i = search(in, root.val);
        root.left = build(in, post, s, i-1, ps, ps+i-s-1);
        root.right = build(in, post, i+1,e, ps+i-s,pe-1);
        return root;
    }
    public int search(int [] in, int v){
        
        for(int i = 0; i<in.length;i++){
            if(v==in[i])
                return i;
        }
        return -1;
    }
}
