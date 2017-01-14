package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Q257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root==null)
            return list;
        //["1->2->5", "1->3"]
        dfs(root, list, "");
        return list;
        
    }
    public void dfs(TreeNode root, List<String> list, String s){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            s+=root.val;
            list.add(s);
            return;
        }
        s+=root.val;
        s+="->";
        dfs(root.left,list,s);
        dfs(root.right, list,s);
    }
}
