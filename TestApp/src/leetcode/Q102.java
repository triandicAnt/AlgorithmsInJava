/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
         List<List<Integer>> list = new ArrayList<>();
        if(root==null)
            return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        List<Integer> l = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode temp = q.remove();
            if(temp==null){
                list.add(new ArrayList<>(l));
                l.clear();
                if(q.size()>0)
                    q.offer(null);
            }else{
                l.add(temp.val);
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
            
        }
        return list;
    }
}