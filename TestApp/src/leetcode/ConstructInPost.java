package leetcode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructInPost {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int in = inorder.length;
        int post = postorder.length;
        if(in!=post)
            return null;
        if(in==1)
            return new TreeNode(inorder[0]);
        return constructTree(inorder,postorder,0, inorder.length-1,0,postorder.length-1);
    }
    public TreeNode constructTree(int [] inorder, int [] postorder,int start, int end,int pstart, int pend){
        if(start>end || pstart>pend)
            return null;
        int x = postorder[pend];
        TreeNode root = new TreeNode(x);
        // if(start==end)
        //     return root;
        int inIndex = search(inorder,x);
        root.left = constructTree(inorder,postorder,start,inIndex-1,pstart,pstart+inIndex-start-1);
        root.right = constructTree(inorder,postorder,inIndex+1,end,pstart+inIndex-start,pend-1);
        return root;
    }
    public int search(int inorder[],int x){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==x)
                return i;
        }
        return -1;
    }
}
