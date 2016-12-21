/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class FlattenBST {
	 public void flatten(TreeNode root) {
	        while(root!=null){
	            //check if left is null or not
	            if(root.left!=null){
	                // find the rightmost of left Node
	                TreeNode rightMost = root.left;
	                while(rightMost.right!=null){
	                    rightMost = rightMost.right;
	                }
	                rightMost.right = root.right;
	                root.right = root.left;
	                root.left = null;
	            }else{
	                root = root.right;
	            }
	        }
	    }
}
