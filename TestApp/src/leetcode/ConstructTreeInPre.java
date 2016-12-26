/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructTreeInPre {
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int p = preorder.length;
        int i = inorder.length;
        
        if(p!=i)
            return null;
        if(i==1)
            return new TreeNode(inorder[0]);
        return constructTree(inorder,preorder,0,inorder.length-1);
    }
    public TreeNode constructTree(int [] inorder, int [] preorder, int start, int end){
        if(start>end)
            return null;
        int x = preorder[preIndex++];
        TreeNode root = new TreeNode(x);
        if(start==end)
            return root;
        int inIndex = search(inorder, x);
        root.left = constructTree(inorder,preorder,start,inIndex-1);
        root.right = constructTree(inorder,preorder,inIndex+1, end);
        return root;
    }
    public int search(int [] inorder, int x){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==x)
                return i;
        }
        return -1;
    }
}
