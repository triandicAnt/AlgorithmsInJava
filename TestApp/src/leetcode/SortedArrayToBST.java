/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class SortedArrayToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(3&3);

	}
	 public TreeNode sortedArrayToBST(int[] nums) {
	        if(nums == null || nums.length<1)
	            return null;
	        // 1,2,3,4,5
	        TreeNode root = constructTree(nums, 0, nums.length-1);
	        return root;
	    }
	    
	    public TreeNode constructTree(int []nums, int l, int h){
	        if(l>h)
	            return null;
	        int m = l+(h-l)/2;
	        TreeNode root = new TreeNode(nums[m]);
	        root.left = constructTree(nums, l,m-1);
	        root.right = constructTree(nums, m+1,h);
	        return root;
	    }
}
