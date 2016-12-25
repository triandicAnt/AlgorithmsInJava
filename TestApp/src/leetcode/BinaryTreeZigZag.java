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
public class BinaryTreeZigZag {
	  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	        List<List<Integer>>  list = new ArrayList<>();
	        if(root == null)
	            return list;
	        Stack<TreeNode> s1 = new Stack<>();
	        Stack<TreeNode> s2 = new Stack<>();
	        s1.push(root);
	        List<Integer> l = new ArrayList<Integer>();
	        while(!s1.isEmpty()|| !s2.isEmpty()){
	            TreeNode temp = s1.pop();
	            if(temp!=null){
	                l.add(temp.val);
	                s2.push(temp.left);
	                s2.push(temp.right);
	            }
	            
	            if(!s1.isEmpty())
	                continue;
	            if(l.size()>0)
	                list.add(new ArrayList<>(l));
	            l.clear();
	            while(!s2.isEmpty()){
	                TreeNode temp1 = s2.pop();
	                if(temp1!=null){
	                    l.add(temp1.val);
	                    s1.push(temp1.right);
	                    s1.push(temp1.left);
	                }
	            }
	           if(l.size()>0)
	                list.add(new ArrayList<>(l));
	            l.clear();
	        }
	        return list;
	    }
}
