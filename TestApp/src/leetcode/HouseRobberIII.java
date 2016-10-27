/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/house-robber-iii/
 */
public class HouseRobberIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	 public int rob(TreeNode root) {
	        if(root == null)
	            return 0;
	        int [] temp = getMoney(root);
	        return Math.max(temp[0],temp[1]);
	    }
	    public int[] getMoney(TreeNode root){
	    	
	        if(root == null)
	            return new int[2];
	        int [] left = getMoney(root.left);
	        int []right = getMoney(root.right);
	        
	        //result[0] contains the max value inclusing root while result[1] contains value exclusing root
	        int[] result = new int [2];
	        result[0] = root.val + left[1] + right[1];
	        result[1] = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
	        return result;
	    }

}
