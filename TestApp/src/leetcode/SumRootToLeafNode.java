/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sudhansu
 *
 */
public class SumRootToLeafNode {

	  public int sumNumbers(TreeNode root) {
	        if(root == null)
	            return 0;
	        List<String> list = new ArrayList<>();
	        printAllPathSum(root,list, "");
	        System.out.println(list);
	        int value = 0;
	        for(String s:list){
	            value+= Integer.parseInt(s);
	        }
	        return value;
	    }
	    public void printAllPathSum(TreeNode root, List<String> list, String path){
			if(root==null)
				return ;
			path+= ""+ root.val;
			if(root.left == null && root.right == null){
			    list.add(path);
				return;
				
			}
			// if the subSum becomes zero at any point before leaf, return true
			printAllPathSum(root.left,  list,path);
			printAllPathSum(root.right, list,path);
		}
}
