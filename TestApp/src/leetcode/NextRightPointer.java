/**
 * 
 */
package leetcode;

/**
 * @author Sudhansu
 *
 */
public class NextRightPointer {

	  public void connect(TreeLinkNode root) {
	        TreeLinkNode prev = root;
	        TreeLinkNode cur = null;
	        
	        while(prev!=null){
	            cur = prev;
	            while(cur!=null && cur.left!=null){
	                cur.left.next = cur.right;
	                if(cur.next!=null){
	                    cur.right.next = cur.next.left;
	                }
	                cur = cur.next;
	            }
	            prev = prev.left;
	        }
	        
	        
	    }
}

 class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; } 
}