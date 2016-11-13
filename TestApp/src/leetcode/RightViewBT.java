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
public class RightViewBT {

	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list= new ArrayList<Integer>();

        if(root == null)
            return list;
        // use the level order traversal of tree
        List<TreeNode> nodeList = new ArrayList<TreeNode>();

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        //list.add(root.val);
        nodeList.add(root);
        q.offer(null);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if(temp==null){
                q.offer(null);
            }else{
                if(temp.left!=null)
                    q.offer(temp.left);
                if(temp.right!=null)
                    q.offer(temp.right);
            }
        }
        for(int i=1; i<nodeList.size();i++){
            if(nodeList.get(i)==null)
                list.add(nodeList.get(i-1).val);
        }
        return list;
    }
	
	  public List<Integer> rightSideViewMod(TreeNode root) {
	        List<Integer> list= new ArrayList<Integer>();

	        if(root == null)
	            return list;
	        // use the level order traversal of tree

	        Queue<TreeNode> q = new LinkedList<TreeNode>();
	        q.offer(root);
	        //list.add(root.val);
	        while(!q.isEmpty()){
	            int s = q.size();
	            int c = 0;
	            for(int i = 0; i<s;i++){
	                TreeNode temp = q.poll();
	                c++;
	                if(c==s)
	                    list.add(temp.val);
	                if(temp.left!=null)
	                    q.offer(temp.left);
	                if(temp.right!=null)
	                    q.offer(temp.right);
	            }
	        
	        }
	      
	        return list;
	    }
}
