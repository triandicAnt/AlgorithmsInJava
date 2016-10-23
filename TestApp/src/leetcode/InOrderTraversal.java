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
public class InOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public List<Integer> inorderTraversal(TreeNode root) {
	        
	        List<Integer> list = new ArrayList<Integer>();
	        if(root == null)
	            return list;
	        Stack<TreeNode> s = new Stack<TreeNode>();
	        TreeNode cur = root;
	        while(true){
	            while(cur!=null){
	                s.push(cur);
	                cur = cur.left;
	            }
	            if(s.isEmpty())
	                break;
	            cur = s.pop();
	            list.add(cur.val);
	            cur = cur.right;
	        }
	        return list;
	    }

}
