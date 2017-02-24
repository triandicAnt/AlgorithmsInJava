/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class NextRightPointerII {
    public void connect(TreeLinkNode root) {
        if(root==null)
            return;
       // do a level order traversal using the next pointer
       TreeLinkNode head = new TreeLinkNode(0);
       while(root!=null){
           TreeLinkNode cur = head;
           while(root!=null){
               if(root.left!=null){
                   cur.next = root.left;
                   cur = cur.next;
               }
               if(root.right!=null){
                   cur.next = root.right;
                   cur = cur.next;
               }
               root = root.next;
           }
           root  = head.next;
           head.next = null;
       }
    }
}
