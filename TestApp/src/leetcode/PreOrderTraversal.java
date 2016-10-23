/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Sudhansu
 *
 */
public class PreOrderTraversal {
	 public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> list = new ArrayList<Integer>();
	        if(root == null)
	            return list;
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        TreeNode cur = root;
	        while(true){
	            while(cur!=null){
	                list.add(cur.val);
	                s.push(cur);
	                cur = cur.left;
	            }
	            if(s.isEmpty())
	                break;
	            cur = s.pop();
	            cur = cur.right;
	        }
	        return list;
 }
}
