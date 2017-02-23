/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class AssignNext {
    public void connect(TreeLinkNode root) {
        if(root==null || root.left ==null || root.right == null)
            return;
        root.left.next = root.right;
        if(root.next!=null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
