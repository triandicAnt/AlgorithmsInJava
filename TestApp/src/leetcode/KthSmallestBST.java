/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	   public int kthSmallest(TreeNode root, int k) {
	        List<Integer> list = new ArrayList<Integer>();
	        inOrder(list, root);
	        return list.get(k-1);
	    }
	    
	    public List<Integer> inOrder(List<Integer> list, TreeNode root){
	        if(root==null)
	            return list;
	        list = inOrder(list, root.left);
	        list.add(root.val);
	        list = inOrder(list, root.right);
	        return list;
	    }
}
